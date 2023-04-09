package com.atguigu.spring.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
@Component
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

	public MySmartInstantiationAwareBeanPostProcessor(){
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...");
	}
	public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...predictBeanType=>"+beanClass+"--"+beanName);
		return null;
	}

	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName)

			throws BeansException {
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...determineCandidateConstructors=>"+beanClass+"--"+beanName);

		return null;
	}

	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...getEarlyBeanReference=>"+bean+"--"+beanName);

		return bean;
	}

}
