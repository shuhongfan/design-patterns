package com.atguigu.design.creatation.singleton;


import java.util.Map;
import java.util.Properties;

public class MainTest {

    public static void main(String[] args) {
//        Person person1 = Person.guiguBoss();
//
//        Person person2 = Person.guiguBoss();
//
//        System.out.println(person1 == person2);

//        Properties properties = System.getProperties();
//        System.out.println(properties);

        //获取当前系统的环境变量
        Map<String, String> getenv = System.getenv();
        System.out.println(getenv);

    }
}
