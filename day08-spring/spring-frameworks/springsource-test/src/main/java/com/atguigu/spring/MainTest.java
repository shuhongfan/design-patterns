package com.atguigu.spring;

import com.atguigu.spring.bean.Person;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;


//https://gitee.com/leifengyang/spring-framework
public class MainTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		Person bean = context.getBean(Person.class);
		System.out.println(bean);
	}

	public static void test01(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Person bean = context.getBean(Person.class);
		System.out.println(bean);

	}
}
