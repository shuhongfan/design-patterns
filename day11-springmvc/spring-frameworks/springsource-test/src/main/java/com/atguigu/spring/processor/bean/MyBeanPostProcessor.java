package com.atguigu.spring.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * Bean组件的 PostProcessor；
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	public MyBeanPostProcessor(){
		System.out.println("MyBeanPostProcessor...");
	}
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor...postProcessAfterInitialization..."+bean+"==>"+beanName);
		return bean;
	}
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor...postProcessBeforeInitialization..."+bean+"==>"+beanName);
		return bean; // new Object();
	}


}
