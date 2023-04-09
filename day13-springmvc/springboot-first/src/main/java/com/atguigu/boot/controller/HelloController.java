package com.atguigu.boot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello66")
    public String hello(){

        return "66666666~~~~~";
    }
}
