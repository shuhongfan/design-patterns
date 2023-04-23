package com.shf.spring.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 多实例
public class Cat {
	private String name;

	public Cat() {
		System.out.println("cat被创建了...");
	}

	@Value("${JAVA_HOME}")
	public void setName(String name) {
		System.out.println("cat...setName正在赋值调用...");
		this.name = name;
	}
}
