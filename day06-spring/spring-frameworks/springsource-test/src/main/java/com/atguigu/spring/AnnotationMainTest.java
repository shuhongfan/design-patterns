package com.atguigu.spring;

import com.atguigu.spring.bean.Cat;
import com.atguigu.spring.bean.Person;
import com.atguigu.spring.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解版Spring的用法
 */
public class AnnotationMainTest {

	public static void main(String[] args) {
//		new ClassPathXmlApplicationContext()

		ApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfig.class);

//		Person bean = applicationContext.getBean(Person.class);
//		System.out.println(bean);


//		String[] names = applicationContext.getBeanDefinitionNames();
//		for (String name : names) {
//			System.out.println(name);
//		}


//		Cat bean1 = applicationContext.getBean(Cat.class);
//
//		Cat bean2 = applicationContext.getBean(Cat.class);
//
//		System.out.println(bean1 == bean2);  //false

//		Person bean1 = applicationContext.getBean(Person.class);
//
//		Cat cat = bean1.getCat();
//
//		Person bean2 = applicationContext.getBean(Person.class);
//
//		Cat cat1 = bean2.getCat();
//		System.out.println(cat1 == cat);  //true
//		System.out.println(cat1);


//		Person bean = applicationContext.getBean(Person.class);
//
//		ApplicationContext context = bean.getContext();
//
//		System.out.println(context == applicationContext);
	}
}
