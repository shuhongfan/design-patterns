package com.atguigu.spring.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
@Component   //bean进行代理增强期间进行使用
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

	public MySmartInstantiationAwareBeanPostProcessor(){
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...");
	}  //预测bean的类型，最后一次改变组件类型。
	public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...predictBeanType=>"+beanClass+"--"+beanName);
		return null;
	}
    //返回我们要使用的构造器候选列表
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName)

			throws BeansException {
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...determineCandidateConstructors=>"+beanClass+"--"+beanName);
		//返回一个我们指定的构造器
		return null;
	}
     //返回早期的bean引用，定义三级缓存中的bean信息
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		System.out.println("MySmartInstantiationAwareBeanPostProcessor...getEarlyBeanReference=>"+bean+"--"+beanName);

		return bean; //
	}

}
