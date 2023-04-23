package com.shf.spring.config;

import com.shf.spring.bean.Cat;
import com.shf.spring.bean.Person;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 导入Bean方法
 * @Import
 * @ImportSelector
 * @ImportBeanDefinitionRegistrar
 */
//@Import({Person.class, MainConfig.MyIportRegistrar.class})
@Configuration
@ComponentScan("com.shf.spring")
public class MainConfig {
	public MainConfig() {
		System.out.println("MainConfig...创建了...");
	}
	//	@Bean
//	public Person person() {
//		Person person = new Person();
//		person.setName("李四");
//		return person;
//	}

	/**
	 * BeanDefinitionRegistry: Bean定义信息注册中心：图纸中心
	 * 		它里面都是BeanDefinition
	 */
//	static class MyIportRegistrar implements ImportBeanDefinitionRegistrar {
//		@Override
//		public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
//											BeanDefinitionRegistry registry) {
////			BeanDefinition 可以什么定义信息，包括需要自动装配什么
//			RootBeanDefinition catDefinition = new RootBeanDefinition();
//			catDefinition.setBeanClass(Cat.class);
//			registry.registerBeanDefinition("tomCat", catDefinition);
//		}
//	}
}
