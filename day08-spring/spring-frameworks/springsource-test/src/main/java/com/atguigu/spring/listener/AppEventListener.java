package com.atguigu.spring.listener;


import com.atguigu.spring.circle.A;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 */

//@Component
public class AppEventListener {

	public AppEventListener(){
		System.out.println("AppEventListener...");
	}

	@EventListener(MessageEvent.class)
	public void listenMessage(MessageEvent event){
		System.out.println("Message事件到达..."+event+"；已发送邮件....");
	}


	@EventListener(ChangeEvent.class)
	public void listenChange(ChangeEvent event){
		System.out.println("Change事件到达..."+event+"；已同步状态....");
	}

	@EventListener(PayloadApplicationEvent.class)
	public void listenPayload(PayloadApplicationEvent<A> event){
		System.out.println("Payload事件到达..."+event.getPayload()+"；已进行处理....");
	}

}
