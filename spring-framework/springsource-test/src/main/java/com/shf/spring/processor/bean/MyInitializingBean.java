package com.shf.spring.processor.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


/**
 * 生命周期接口
 */
@Component
public class MyInitializingBean implements InitializingBean {

	public MyInitializingBean(){
		System.out.println("MyInitializingBean....");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("MyInitializingBean...afterPropertiesSet...");
	}
}
