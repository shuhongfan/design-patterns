package com.atguigu.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component //容器中会拿到所有的事件监听器，挨个遍历调用 onApplicationEvent
public class App implements ApplicationListener<ApplicationEvent> {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("");
	}
}
