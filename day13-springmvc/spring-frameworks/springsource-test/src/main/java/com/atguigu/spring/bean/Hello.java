package com.atguigu.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class Hello {

	//下面的功能还可以使用xxxAware接口
	@Autowired //为啥能进来，之前就保存到容器的实例缓存池了；底层组件先在 resolvableDependencies
	private ApplicationContext applicationContext;

	@Autowired  //BeanFactory实例池里面有
	private Environment environment;

	@Autowired  //注入环境变量信息
	private Map<String,String> systemEnvironment;
}
