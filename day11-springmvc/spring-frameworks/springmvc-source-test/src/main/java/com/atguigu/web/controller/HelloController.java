package com.atguigu.web.controller;


import com.atguigu.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller; 如果有父子容器 @Component，默认是在父容器中，还找不到
//@Component+@RequestMapping
@RestController
public class HelloController {

	public HelloController(){
		System.out.println("HelloController.....");
	}

	@Autowired
	HelloService helloService;

	@GetMapping("/hello") // 所有的xxxMapping都是RequestMapping
	public String sayHello(){

		String mvc = helloService.say("MVC");
		return mvc;
	}
}
