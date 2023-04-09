package com.atguigu.spring.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 工厂bean
 * 普通bean
 * 区别：
 * 	1、Person=普通bean，注册的组件对象就是Person对象，类型就是Person
 * 	2、工厂bean=实现了FactoryBean接口的组件。注册的不是HelloFactory，
 * 			而是HelloFactory这个工厂调用了getObject()返回的对象，类型是getObjectType指定的类型
 * 		MyBatis和Spring的整合	SqlSessionFactoryBean
 */

//@Component  //也可以实现 SmartFactoryBean。指定提前加载
public class HelloFactory implements FactoryBean<Hello> {

	@Override
	public Hello getObject() throws Exception {
		return new Hello(); //这是最终获取到的对象
	}

	@Override
	public Class<?> getObjectType() {
		return Hello.class;
	}
}
