package com.atguigu.spring.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	public MyInstantiationAwareBeanPostProcessor(){
		System.out.println("MyInstantiationAwareBeanPostProcessor...");
	}
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("MyInstantiationAwareBeanPostProcessor...postProcessBeforeInstantiation=>"+beanClass+"--"+beanName);
		return null;
	}
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("MyInstantiationAwareBeanPostProcessor...postProcessAfterInstantiation=>"+bean+"--"+beanName);
		return true;
	}
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
			throws BeansException {
		System.out.println("MyInstantiationAwareBeanPostProcessor...postProcessProperties=>"+bean+"--"+beanName);
		return null;
	}
//	public PropertyValues postProcessPropertyValues(
//			PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
//		System.out.println("MyInstantiationAwareBeanPostProcessor...postProcessProperties");
//		return pvs;
//	}
}

