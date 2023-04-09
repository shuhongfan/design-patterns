package com.atguigu.web;

import com.atguigu.web.config.SpringConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 * 只要写了这个，相当于配置了SpringMVC的DispatcherServlet
 * 1、Tomcat一启动就加载他
 * 		1）、创建了容器、制定了配置类（所有ioc、aop等spring的功能就ok）
 * 		2）、注册一个Servlet；	DispatcherServlet；
 * 		3）、以后所有的请求都交给了 DispatcherServlet；
 * 	效果，访问Tomcat部署的这个Web应用下的所有请求都会被 	DispatcherServlet 处理
 * 	DispatcherServlet就会进入强大的基于注解的mvc处理流程（@GetMapping）
 * 必须Servlet3.0以上才可以；Tomcat6.0以上才支持Servlet3.0规范
 *
 * Servlet3.0是javaEE的Web的规范标准，Tomcat是Servlet3.0规范的一个实现；
 */
public class AppStarter /** implements WebApplicationInitializer */ {
//	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//1、创建ioc容器
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpringConfig.class); //2、传入一个配置类
		//以上截止，ioc容器都没有启动
		//3、配置了 DispatcherServlet,利用Servlet的初始化机制
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/"); //映射路径

		//启动了容器？上面的Servlet添加到 servletContext 里面以后，Tomcat就会对 DispatcherServlet进行初始化
		//<servlet></servlet>
//		servletContext.addServlet("abc",XXXX.class)

	}
}
