package com.atguigu.web.controller;


import com.atguigu.web.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

//@Controller; 如果有父子容器 @Component，默认是在父容器中，还找不到
//@Component+@RequestMapping
//@RestController
@Controller
public class HelloController {

	public HelloController(){
		System.out.println("HelloController.....");
	}

	@Autowired
	HelloService helloService;


	/**
	 * RequestMappingHandlerAdapter:怎么反射执行到这个方法，
	 *   确定每一个参数的值，以及处理返回值等等
	 * @param name
	 * @return  ModelAndView、Model、void\String xxxx  请求数据到自定义Object属性的映射需要用到
	 * 				（WebDataBinder【数据类型转换、绑定错误处理】）Factory
	 */
//	@ResponseBody

	@GetMapping("/hello") // 所有的xxxMapping都是RequestMapping
	public String   sayHello(String name, //可以从请求参数中得到
						   @RequestParam("user")String user, //可以从请求参数中得到
						   HttpSession session, HttpServletRequest request, //原生的session对象
						   @RequestHeader("User-Agent") String  ua){ //@RequestParam Map<String,Object> params：所有请求参数全封装进来
		// @RequestHeader("User-Agent") String  ua 获取指定请求头的值
		String header = request.getHeader("User-Agent");
		//方法的签名，到底能写那些？
		//详细参照 https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments
		//https://www.bilibili.com/video/BV19K4y1L7MT?p=32
		String mvc = helloService.say(user+"：MVC"+name);
		session.setAttribute("msg",mvc);


		//SpringMVC的目标方法能写哪些返回值
		//https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-return-types
		return "index.jsp";
	}
}
