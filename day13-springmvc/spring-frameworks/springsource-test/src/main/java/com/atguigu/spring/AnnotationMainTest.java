package com.atguigu.spring;


import com.atguigu.spring.aop.HelloService;
import com.atguigu.spring.bean.Hello;
import com.atguigu.spring.circle.A;
import com.atguigu.spring.config.AopOpenConfig;
import com.atguigu.spring.config.MainConfig;
import com.atguigu.spring.listener.AppEventPublisher;
import com.atguigu.spring.listener.ChangeEvent;
import com.atguigu.spring.listener.MessageEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注解版Spring的用法
 */
public class AnnotationMainTest {

	public static void main(String[] args) {
//		new ClassPathXmlApplicationContext()

		ApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConfig.class);


//		Hello bean = applicationContext.getBean(Hello.class);
//		Hello bea2 = applicationContext.getBean(Hello.class);
//		System.out.println(bean == bea2); //还是单例

		//循环引用,原理测试
		//AOP,原理测试
		HelloService helloService = applicationContext.getBean(HelloService.class);

		//代理对象来调用方法
		helloService.sayHello("zhangsan");



//		applicationContext.publishEvent(new Object());
//		applicationContext.publishEvent(new ApplicationEvent() {
//			@Override
//			public String toString() {
//				return super.toString();
//			}
//		});

		//测试事件
		AppEventPublisher eventPublisher = applicationContext.getBean(AppEventPublisher.class);
		eventPublisher.publish(new A());
		eventPublisher.publish(new MessageEvent("hello，你好"));
		eventPublisher.publish(new ChangeEvent(eventPublisher,"sending..."));


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
