package com.shf.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 工厂Bean
 * 普通Bean
 * 区别：
 * 	1. Person = 普通bean，注册的组件对象就是Person对象，类型就是Person
 * 	2. 工厂bean = 实现了FactoryBean接口的组件。注册的不是HelloFactory，
 * 				  而是HelloFactory这个工厂调用了getObject()返回的对象，
 * 				  类型是getObjectType（）返回的对象
 *
 *	Mybatis和Spring整合SqlSessionFactoryBean
 */
public class HelloFactory implements FactoryBean<Hello> {

	@Override
	public Hello getObject() throws Exception {
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}
}
