package com.shf.spring;

import com.shf.spring.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Person bean = classPathXmlApplicationContext.getBean(Person.class);
		System.out.println(bean);
	}
}