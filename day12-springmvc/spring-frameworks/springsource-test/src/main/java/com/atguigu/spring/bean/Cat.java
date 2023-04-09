package com.atguigu.spring.bean;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//容器就应该给Cat再创建一个对象
@Component
public class Cat implements InitializingBean, SmartInitializingSingleton {

	public Cat(){
		System.out.println("cat被创建了...");
	}

	private String name;


	@Value("${JAVA_HOME}") //自动赋值功能
	public void setName(String name) {
		System.out.println("cat....setName正在赋值调用....");
		this.name = name;
	}
	//注解怎么定义这个是初始化方法？
	public String getName() {
		return name;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("CatInitializingBean..afterPropertiesSet...");
	}

	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("所有组件都创建完成以后，再来执行这个方法.....");
	}
}
