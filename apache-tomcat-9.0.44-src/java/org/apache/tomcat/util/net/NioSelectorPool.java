/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tomcat.util.net;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread safe non blocking selector pool
 */
public class NioSelectorPool {

    protected NioBlockingSelector blockingSelector;

    protected volatile Selector sharedSelector;

    protected boolean shared = Boolean.parseBoolean(System.getProperty("org.apache.tomcat.util.net.NioSelectorShared", "true"));
    protected int maxSelectors = 200;
    protected long sharedSelectorTimeout = 30000;
    protected int maxSpareSelectors = -1;
    protected boolean enabled = true;

    protected AtomicInteger active = new AtomicInteger(0);
    protected AtomicInteger spare = new AtomicInteger(0);
    protected ConcurrentLinkedQueue<Selector> selectors = new ConcurrentLinkedQueue<>();

    protected Selector getSharedSelector() throws IOException {
        if (shared && sharedSelector == null) {
            synchronized (NioSelectorPool.class) {
                if (sharedSelector == null) {
                    sharedSelector = Selector.open();
                }
            }
        }
        return  sharedSelector;
    }

    public Selector get() throws IOException{
        if (shared) {
            return getSharedSelector();
        }
        if ((!enabled) || active.incrementAndGet() >= maxSelectors) {
            if (enabled) {
                active.decrementAndGet();
            }
            return null;
        }
        Selector s = null;
        try {
            s = selectors.size() > 0 ? selectors.poll() : null;
            if (s == null) {
                s = Selector.open();
            } else {
                spare.decrementAndGet();
            }
        } catch (NoSuchElementException x) {
            try {
                s = Selector.open();
            } catch (IOException iox) {
            }
        } finally {
            if (s == null) {
                active.decrementAndGet();// we were unable to find a selector
            }
        }
        return s;
    }



    public void put(Selector s) throws IOException {
        if (shared) {
            return;
        }
        if (enabled) {
            active.decrementAndGet();
        }
        if (enabled && (maxSpareSelectors == -1 || spare.get() < Math.min(maxSpareSelectors, maxSelectors))) {
            spare.incrementAndGet();
            selectors.offer(s);
        } else {
            s.close();
        }
    }

    public void close() throws IOException {
        enabled = false;
        Selector s;
        while ((s = selectors.poll()) != null) {
            s.close();
        }
        spare.set(0);
        active.set(0);
        if (blockingSelector != null) {
            blockingSelector.close();
        }
        if (shared && getSharedSelector() != null) {
            getSharedSelector().close();
            sharedSelector = null;
        }
    }

    public void open(String name) throws IOException {
        enabled = true;
        getSharedSelector();
        if (shared) {
            blockingSelector = new NioBlockingSelector();
            blockingSelector.open(name, getSharedSelector());
        }

    }

    /**
     * Performs a write using the bytebuffer for data to be written and a
     * selector to block (if blocking is requested). If the
     * <code>selector</code> parameter is null, and blocking is requested then
     * it will perform a busy write that could take up a lot of CPU cycles.
     * @param buf           The buffer containing the data, we will write as long as <code>(buf.hasRemaining()==true)</code>
     * @param socket        The socket to write data to
     * @param selector      The selector to use for blocking, if null then a busy write will be initiated
     * @param writeTimeout  The timeout for this write operation in milliseconds, -1 means no timeout
     * @return the number of bytes written
     * @throws EOFException if write returns -1
     * @throws SocketTimeoutException if the write times out
     * @throws IOException if an IO Exception occurs in the underlying socket logic
     */
    public int write(ByteBuffer buf, NioChannel socket, Selector selector, long writeTimeout)
            throws IOException {
        if (shared) {
            return blockingSelector.write(buf, socket, writeTimeout);
        }
        if (socket.getSocketWrapper().previousIOException != null) {
            /*
             * Socket has previously seen an IOException on write.
             *
             * Blocking writes assume that buffer is always fully written so
             * there is no code checking for incomplete writes, retaining
             * the unwritten data and attempting to write it as part of a
             * subsequent write call.
             *
             * Because of the above, when an IOException is triggered we
             * need so skip subsequent attempts to write as otherwise it
             * will appear to the client as if some data was dropped just
             * before the connection is lost. It is better if the client
             * just sees the dropped connection.
             */
            throw new IOException(socket.getSocketWrapper().previousIOException);
        }
        SelectionKey key = null;
        int written = 0;
        boolean timedout = false;
        int keycount = 1; //assume we can write
        long time = System.currentTimeMillis(); //start the timeout timer
        try {
            while ((!timedout) && buf.hasRemaining()) {
                int cnt = 0;
                if ( keycount > 0 ) { //only write if we were registered for a write
                    cnt = socket.write(buf); //write the data
                    if (cnt == -1) {
                        throw new EOFException();
                    }

                    written += cnt;
                    if (cnt > 0) {
                        time = System.currentTimeMillis(); //reset our timeout timer
                        continue; //we successfully wrote, try again without a selector
                    }
                }
                if (selector != null) {
                    //register OP_WRITE to the selector
                    if (key == null) {
                        key = socket.getIOChannel().register(selector, SelectionKey.OP_WRITE);
                    } else {
                        key.interestOps(SelectionKey.OP_WRITE);
                    }
                    if (writeTimeout == 0) {
                        timedout = buf.hasRemaining();
                    } else if (writeTimeout < 0) {
                        keycount = selector.select();
                    } else {
                        keycount = selector.select(writeTimeout);
                    }
                }
                if (writeTimeout > 0 && (selector == null || keycount == 0)) {
                    timedout = (System.currentTimeMillis() - time) >= writeTimeout;
                }
            }
            if (timedout) {
                socket.getSocketWrapper().previousIOException = new SocketTimeoutException();
                throw socket.getSocketWrapper().previousIOException;
            }
        } finally {
            if (key != null) {
                key.cancel();
                if (selector != null) selector.selectNow();//removes the key from this selector
            }
        }
        return written;
    }

    /**
     * Performs a blocking read using the bytebuffer for data to be read and a selector to block.
     * If the <code>selector</code> parameter is null, then it will perform a busy read that could
     * take up a lot of CPU cycles.
     * @param buf ByteBuffer - the buffer containing the data, we will read as until we have read at least one byte or we timed out
     * @param socket SocketChannel - the socket to write data to
     * @param selector Selector - the selector to use for blocking, if null then a busy read will be initiated
     * @param readTimeout long - the timeout for this read operation in milliseconds, -1 means no timeout
     * @return the number of bytes read
     * @throws EOFException if read returns -1
     * @throws SocketTimeoutException if the read times out
     * @throws IOException if an IO Exception occurs in the underlying socket logic
     */
    public int read(ByteBuffer buf, NioChannel socket, Selector selector, long readTimeout)
            throws IOException {
        if (shared) {
            return blockingSelector.read(buf, socket, readTimeout);
        }
        SelectionKey key = null;
        int read = 0;
        boolean timedout = false;
        int keycount = 1; //assume we can write
        long time = System.currentTimeMillis(); //start the timeout timer
        try {
            while (!timedout) {
                int cnt = 0;
                if (keycount > 0) { //only read if we were registered for a read
                    cnt = socket.read(buf);
                    if (cnt == -1) {
                        if (read == 0) {
                            read = -1;
                        }
                        break;
                    }
                    read += cnt;
                    if (cnt > 0) continue; //read some more
                    if (cnt == 0 && read > 0) {
                        break; //we are done reading
                    }
                }
                if (selector != null) {//perform a blocking read
                    //register OP_WRITE to the selector
                    if (key == null) {
                        key = socket.getIOChannel().register(selector, SelectionKey.OP_READ);
                    } else {
                        key.interestOps(SelectionKey.OP_READ);
                    }
                    if (readTimeout == 0) {
                        timedout = (read == 0);
                    } else if (readTimeout < 0) {
                        keycount = selector.select();
                    } else {
                        keycount = selector.select(readTimeout);
                    }
                }
                if (readTimeout > 0 && (selector == null || keycount == 0)) {
                    timedout = (System.currentTimeMillis() - time) >= readTimeout;
                }
            }
            if (timedout) {
                throw new SocketTimeoutException();
            }
        } finally {
            if (key != null) {
                key.cancel();
                if (selector != null) {
                    selector.selectNow();//removes the key from this selector
                }
            }
        }
        return read;
    }

    public void setMaxSelectors(int maxSelectors) {
        this.maxSelectors = maxSelectors;
    }

    public void setMaxSpareSelectors(int maxSpareSelectors) {
        this.maxSpareSelectors = maxSpareSelectors;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setSharedSelectorTimeout(long sharedSelectorTimeout) {
        this.sharedSelectorTimeout = sharedSelectorTimeout;
    }

    public int getMaxSelectors() {
        return maxSelectors;
    }

    public int getMaxSpareSelectors() {
        return maxSpareSelectors;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public long getSharedSelectorTimeout() {
        return sharedSelectorTimeout;
    }

    public ConcurrentLinkedQueue<Selector> getSelectors() {
        return selectors;
    }

    public AtomicInteger getSpare() {
        return spare;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }
}
