package com.atguigu.spring.config;


import com.atguigu.spring.aop.HelloService;
import com.atguigu.spring.bean.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Method;


/**
 * 这是一个配置类
 */

//@Import({ MainConfig.MyImportRegistrar.class})
//@Import(AspectJAutoProxyRegistrar.class)
@ComponentScan("com.atguigu.spring")
@Configuration
public class MainConfig {

	@Autowired
	ApplicationEventPublisher applicationEventPublisher;

	public MainConfig(){
		System.out.println("MainConfig...创建了....");
//		applicationEventPublisher.publishEvent();
	}

//	@Bean(initMethod = "")
//	public Person person(){
//		Person person = new Person();
//		person.setName("李四");
//		return person;
//	}


	/**
	 * 		BeanDefinitionRegistry：Bean定义信息注册中心：图纸中心;
	 * 				它里面都是BeanDefinition
	 *
	 * 	<bean class="com.atguigu.spring.bean.Person" id="person">
	 * 		<property name="name" value="张三"/>
	 * 	</bean>
	 * 	 对应
	 * 	RootBeanDefinition
	 *
	 */
	static class MyImportRegistrar implements ImportBeanDefinitionRegistrar{
		@Override
		public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
											BeanDefinitionRegistry registry) {


//			Enhancer enhancer = new Enhancer();
//			enhancer.setCallbacks(new MethodInterceptor(){
//
//				@Override
//				public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//					return null;
//				}
//			});
//			enhancer.setSuperclass(HelloService.class);
			// BeanDefinition
			RootBeanDefinition catDefinition = new RootBeanDefinition();
			catDefinition.setBeanClass(Cat.class);
//			catDefinition.setInitMethodName("aaa");
			//可以声明定义信息，包括我需要自动装配什么？
//			catDefinition.setInstanceSupplier(()-> new Cat());
			//Spring 这个实例的类型，名字
			registry.registerBeanDefinition("tomCat",catDefinition);
		}
	}
}


