package com.atuigu.boot;

import com.atuigu.boot.controller.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.*;


/**
 *
 * SpringBoot整合了Spring和SpringMVC，boot底层都是spring\springmvc
 * 为什么 @SpringBootApplication +
 *   SpringApplication.run(SpringbootSourceApplication.class, args);
 *   能把Spring+SpringMVC+Tomcat+其他场景都整合进来
 *
 *
 * 1）、依赖环节；SpringBoot抽取的各种 spring-boot-starter-xxx 给我们导入了很多依赖（Spring\SpringMVC\embedTomcat）
 * 以后参考 https://docs.spring.io/spring-boot/docs/2.4.4/reference/html/using-spring-boot.html#using-boot-starter
 *
 *
 * 2）、运行原理
 *    @SpringBootConfiguration：代表这是容器中的一个配置类，一个组件【@Configuration配置类会被后置处理器来分析 ConfigurationClassPostProcessor】
 *    @EnableAutoConfiguration：导入所有功能组件
 */
//@SpringBootApplication
//@SpringBootConfiguration
@Configuration
//@AutoConfigurationPackage  //导入组件  AutoConfigurationPackages.Registrar.class
////@Import(AutoConfigurationPackages.Registrar.class)
//@Import(AutoConfigurationImportSelector.class) //导入组件
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public class SpringbootSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSourceApplication.class, args);
    }

    @Bean  //所有的xxxRegistrationBean都是允许我们注册原生的Servlet组件进去，
    //利用 ServletContextInitializer在Tomcat启动完成以后进行回调的机制
    ServletRegistrationBean<HelloServlet> registrationBean(){

        ServletRegistrationBean<HelloServlet> registrationBean = new ServletRegistrationBean<>(new HelloServlet());
        registrationBean.addUrlMappings("/he66");
        return registrationBean;
    }



}
