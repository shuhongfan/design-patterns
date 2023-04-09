package com.atguigu.spring.listener;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;
/**
 * 事件需要实现序列化接口
 */
public class ChangeEvent extends ApplicationEvent implements Serializable {
	private static final long serialVersionUID = 0L;
	private String state;
	private ChangeEvent(Object source) {
		super(source);
	}

	public ChangeEvent(Object source,String state){
		super(source);
		this.state = state;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "ChangeEvent{" +
				"state='" + state + '\'' +
				", source=" + source +
				'}';
	}
}
