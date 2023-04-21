package com.shf.design.singleton;

public class Person {
    private String name;
    private String age;

    private static Person instance;

//    构造器私有，外部不能实例化
    private Person() {

    }

//    提供给外部的方法
    public static Person guiguBoss() {
        if (instance == null) {
            synchronized (Person.class) {
                if (instance == null) {
                    Person person = new Person();
                    instance = person;
                }
            }
        }
        return instance;
    }
}
