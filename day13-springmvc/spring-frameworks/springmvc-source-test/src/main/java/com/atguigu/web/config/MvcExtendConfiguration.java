package com.atguigu.web.config;


import com.atguigu.web.view.MeiNvViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 我的视图解析器和SpringMVC默认的都在一起
 *
 * 容器中有 WebMvcConfigurer 类型的组件（@Component\@Configuration）就行
 */

@EnableWebMvc //启用SpringMVC功能
@Configuration //
public class MvcExtendConfiguration implements WebMvcConfigurer {


	@Override  //配置视图解析器
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(new MeiNvViewResolver());
	}



}
