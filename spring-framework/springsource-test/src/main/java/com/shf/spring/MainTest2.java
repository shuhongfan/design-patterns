package com.shf.spring;

import com.shf.spring.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		Person bean = context.getBean(Person.class);
		System.out.println(bean);
	}
}
