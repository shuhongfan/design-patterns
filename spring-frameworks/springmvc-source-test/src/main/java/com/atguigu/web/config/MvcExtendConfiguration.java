package com.atguigu.web.config;


import com.atguigu.web.view.MeiNvViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 我的视图解析器和SpringMVC默认的都在一起
 *
 * 容器中有 WebMvcConfigurer 类型的组件（@Component\@Configuration）就行
 */

@EnableWebMvc //启用SpringMVC功能，修改SpringMVC底层行为就会很方便只需要实现 WebMvcConfigurer 即可
// 不要这个注解回到以前默认模式，所有组件DispatcherServlet初始化的时候没有，直接用配置文件中指定的默认的组件
// 没有预留扩展接口，需要我们自己重新替换


//1、WebMvcConfigurer+@EnableWebMvc 定制和扩展SpringMVC功能
//2、@EnableWebMvc导入的类会加入SpringMVC的很多核心组件，拥有默认功能
//3、这些默认功能在扩展的时候都是留给接口 WebMvcConfigurer（访问者，拿到真正的内容进行修改） 可以介入
//4、MeiNvViewResolver+InternalResourceViewResolver
//5、@EnableWebMvc开启了SpringMVC === <mvc:annotation-driven/>，即使是以前自己也要配置默认视图解析器
@Configuration //
public class MvcExtendConfiguration implements WebMvcConfigurer {

// 另外一种
//@Configuration 	MvcExtendConfiguration extends DelegatingWebMvcConfiguration
// 1、拿到父类@Bean的方法，还是给容器中放了组件
// 2、只是为了实现一个效果，就是让 DelegatingWebMvcConfiguration 的类或者子类放在容器中，
// 3、只要这个 DelegatingWebMvcConfiguration 生效，他从容器中拿所有的configure进行
// 4、两种方式把 DelegatingWebMvcConfiguration 搞进来 + 一种方式自己写扩展
	//1）、随便在哪个配置类位置加 @EnableWebMvc，然后只需要给 容器中放 WebMvcConfigurer即可
	//2）、自己写一个配置类（在容器中）来继承 DelegatingWebMvcConfiguration，然后只需要给 容器中放 WebMvcConfigurer即可;继承这个可以
	//3）、自己写一个配置类（在容器中）来继承 WebMvcConfigurationSupport，我们只能去实现模板方法，进行扩展

//这个DelegatingWebMvcConfiguration的特效就是，
	//1、给容器中放组件比如：HandlerMapping
	//2、HandlerMapping的关键环节留给模板方法
	//3、DelegatingWebMvcConfiguration拿到所有的 WebMvcConfigurer，在模板方法实现的时候，
// 由WebMvcConfigurer进行定制
	@Override  //配置视图解析器，升级了这个组件的功能
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(new MeiNvViewResolver()); //判断美女
		//完全改变  ，没有 InternalResourceViewResolver


		//不改源码就如下操作
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("");
//		viewResolver.setSuffix(".jsp"); //controller的返回值就不用写jsp
//		registry.viewResolver(viewResolver);
		//
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

	}
}
