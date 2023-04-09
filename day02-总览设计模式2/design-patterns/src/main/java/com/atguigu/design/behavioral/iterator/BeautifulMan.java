package com.atguigu.design.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象聚合类
 */
public abstract class BeautifulMan {

    //不方便暴露给外界的集合。只允许外界获取而不可以操作
    private List<String> girlFriends = new ArrayList<>();

    abstract void likeYou(String name);
    abstract void sayBye(String name);

    /**
     * 获取迭代器
     * @return
     */
    public Itr getIterator(){
        return null;
    }

    /**
     * 具体迭代器
     */
    class Iterator implements Itr{
       private int cursor = 0; //当前指针
       public boolean hasNext(){
           return true;
       }

       public String next(){
           return null;
       }
    }


    /**
     * 抽象迭代器，写在外部该怎么写？
     */
    interface Itr {
        boolean hasNext();
        String next();
    }

}
