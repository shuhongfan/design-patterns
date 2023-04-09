package com.atguigu.web.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice  //专门处理所有controller异常的，默认加在容器中
public class MyExceptionHandler {



	@ResponseBody
	@ExceptionHandler(value = {ArithmeticException.class})
//	@GuiguExceptionHandler  //发送到告警日志，存档，
	public String handleZeroException(Exception exception){
		//参数位置  https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-exceptionhandler-args
		//返回值   https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-exceptionhandler-return-values
		// 异常处理器的功能怎么增强出来的【参数解析器，返回值处理器】.....
		return "Error";
	}
}
