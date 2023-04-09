package com.atguigu.spring;


import com.atguigu.spring.bean.Hello;
import com.atguigu.spring.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注解版Spring的用法
 */
public class AnnotationMainTest {

	public static void main(String[] args) {
//		new ClassPathXmlApplicationContext()

		ApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfig.class);


		Hello bean = applicationContext.getBean(Hello.class);

		Hello bea2 = applicationContext.getBean(Hello.class);
		System.out.println(bean == bea2); //还是单例

		//循环引用,原理测试
		//AOP,原理测试
//		HelloService helloService = applicationContext.getBean(HelloService.class);
//		helloService.sayHello("zhangsan");





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
