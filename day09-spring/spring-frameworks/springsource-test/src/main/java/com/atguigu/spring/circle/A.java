package com.atguigu.spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
	private B b;

	public A(){
		System.out.println("A...构造....");
	}

	@Autowired
	public void setB(B b) {
		this.b = b;
	}
}
