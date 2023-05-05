package com.atguigu.spring.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
	public MyMergedBeanDefinitionPostProcessor(){
		System.out.println("MyMergedBeanDefinitionPostProcessor...");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyMergedBeanDefinitionPostProcessor...postProcessBeforeInitialization...=>"+bean+"--"+beanName);
		return bean; //null
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyMergedBeanDefinitionPostProcessor...postProcessAfterInitialization..=>"+bean+"--"+beanName);
		return null;
	}

	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		System.out.println("MyMergedBeanDefinitionPostProcessor...postProcessMergedBeanDefinition..=>"+beanName+"--"+beanType+"---"+beanDefinition);
	}

	@Override
	public void resetBeanDefinition(String beanName) {
		System.out.println("MyMergedBeanDefinitionPostProcessor...resetBeanDefinition.."+beanName);

	}
}
