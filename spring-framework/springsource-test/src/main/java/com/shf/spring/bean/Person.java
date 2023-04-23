package com.shf.spring.bean;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * Aware接口：帮我们装配Spring底层的一些组件
 * 1. Bean的功能增强全部都是有BeanPostProcessor + InitializingBean （合起来完成的）
 * 2. 骚操作就是 BeanPostProcessor + InitializingBean
 *
 * Autowired 是怎么完成的
 * Person为什么能把ApplicationContext、MessageSource当为自己的参数传进来？
 * 		- 通过实现接口的方式自动注入了ApplicationContext、MessageSource 是由BeanPostProcessor 完成的
 */
@Data
@Component
public class Person implements ApplicationContextAware, MessageSourceAware {

//	@Autowired
	ApplicationContext context;  // 可以要到IOC容器
	MessageSource messageSource;

	public Person() {
		System.out.println("person创建...");
	}

	private String name;

//	@Autowired
	private Cat cat;

	@Autowired
	public void setCat(Cat cat) {
		this.cat = cat;
	}

	@Lookup // 去容器中找，由于是原型模式，所以多实例
	public Cat getCat() {
		return cat;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		利用回调机制，把ioc容器传入
		context = applicationContext;
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		messageSource = messageSource;
	}
}
