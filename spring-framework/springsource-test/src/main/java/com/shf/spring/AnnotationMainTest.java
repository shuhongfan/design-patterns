package com.shf.spring;

import com.shf.spring.aop.HelloService;
import com.shf.spring.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注解Spring的用法
 */
public class AnnotationMainTest {
	public static void main(String[] args) {
//		new ClassPathXmlApplicationContext()
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
//		Person bean = context.getBean(Person.class);
//		System.out.println(bean);

//		String[] beanDefinitionNames = context.getBeanDefinitionNames();
//		for (String beanDefinitionName : beanDefinitionNames) {
//			System.out.println(beanDefinitionName);
//		}

//		Cat bean1 = context.getBean(Cat.class);
//		Cat bean2 = context.getBean(Cat.class);
//		System.out.println(bean1 == bean2);

//		Person bean1 = context.getBean(Person.class);
//		Cat cat = bean1.getCat();
//
//		Person bean2 = context.getBean(Person.class);
//		Cat cat1 = bean2.getCat();
//		System.out.println(cat1 == cat); // true  Person是单实例的，导致获取的Cat就是第一次创建Person对象的时候，容器初始化cat

//		Person person = context.getBean(Person.class);
//		ApplicationContext context1 = person.getContext();
//		MessageSource messageSource = person.getMessageSource();
//		System.out.println(context1);
//		System.out.println(messageSource);
//		System.out.println(context == context1);

//		AOP
		HelloService helloService = context.getBean(HelloService.class);
		helloService.sayHello("zhangsan");
	}
}
