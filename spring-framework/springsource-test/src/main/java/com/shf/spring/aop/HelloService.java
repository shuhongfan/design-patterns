package com.shf.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
	public HelloService() {
		System.out.println("HelloService...构造器");
	}

	public String sayHello(String name) {
		String result = "你好：" + name;
		System.out.println(result);
		int length = name.length();
		return result + "---" + length;
	}
}
