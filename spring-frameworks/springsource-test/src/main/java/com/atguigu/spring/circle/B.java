package com.atguigu.spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//肯定成功的
@Component
public class B {

	private A a;

//	@Autowired //事务 b.tx1();  tx(){tx1()}
//	private B b;

	public B(){
		System.out.println("B...构造....");
	}

	@Autowired
	public void setA(A a) {
		this.a = a;
	}
}
