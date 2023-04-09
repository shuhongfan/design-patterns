package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //导入的所有组件，有些组件放到容器中，有些组件会在生命周期的时候强化
@SpringBootApplication  //只剩下分析这个功能引入的组件，什么时候工作，怎么工作
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
