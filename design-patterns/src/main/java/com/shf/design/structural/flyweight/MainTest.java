package com.shf.design.structural.flyweight;

/**
 * 享元模式返回的是本人
 * 原型返回的是克隆人
 */
public class MainTest {
    public static void main(String[] args) {
        AbstractWaitressFlyweight waitress = ZuDao.getWaitress("");
        waitress.service();
    }
}
