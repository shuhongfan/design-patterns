package com.shf.design.creatation.singleton;

import java.util.Map;

public class MainTest {
    public static void main(String[] args) {
        Person person1 = Person.guiguBoss();
        Person person2 = Person.guiguBoss();
        System.out.println(person2==person1);

//        Properties properties = System.getProperties();
//        System.out.println(properties);

        Map<String, String> getenv = System.getenv();
        System.out.println(getenv);
    }
}
