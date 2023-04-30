package com.shf.spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
	private A a;

	@Autowired
	private B b;

	public B() {
		System.out.println("B...构造...");
	}

	@Autowired
	public void setA(A a) {
		this.a = a;
	}
}
