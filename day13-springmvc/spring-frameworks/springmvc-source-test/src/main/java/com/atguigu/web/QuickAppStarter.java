package com.atguigu.web;

import com.atguigu.web.config.SpringConfig;
import com.atguigu.web.config.SpringMVCConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;


/**
 * 最快速的整合注解版SpringMVC和Spring的
 */
public class QuickAppStarter extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override //根容器的配置（Spring的配置文件===Spring的配置类）
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{SpringConfig.class};
	}

	@Override //web容器的配置（SpringMVC的配置文件===SpringMVC的配置类）
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{SpringMVCConfig.class};
	}

	@Override //Servlet的映射，DispatcherServlet的映射路径
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//		super.customizeRegistration(registration);

//		registration.addMapping("");//
	}
}
