package com.atguigu.spring.listener;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * 事件需要实现序列化接口
 */
public class MessageEvent extends ApplicationEvent implements Serializable {
	private static final long serialVersionUID = 0L;

	public MessageEvent(String source) {
		super(source);
	}

	@Override
	public String toString() {
		return "MessageEvent{" +
				", source=" + source +
				'}';
	}
}
