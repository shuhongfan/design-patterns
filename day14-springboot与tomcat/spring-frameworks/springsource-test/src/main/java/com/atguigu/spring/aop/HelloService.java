package com.atguigu.spring.aop;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;


@Component  //切面存在的化就会返回代理对象
public class HelloService {

	public HelloService(){
		System.out.println("....");
	}

	public String sayHello(String name){
		String result = "你好："+name;
		System.out.println(result);
		int length = name.length();
		return result + "---" + length;
	}
}
