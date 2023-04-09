package com.atguigu.design.structural.flyweight;


/**
 *
 */
public class MainTest {

    public static void main(String[] args) {

        //1、我
        AbstractWaitressFlyweight waitress = ZuDao.getWaitress("");
        waitress.service();
        System.out.println(waitress);
        //2、佟老师
        AbstractWaitressFlyweight waitress1 = ZuDao.getWaitress("");
        waitress1.service();
        System.out.println(waitress1);

        waitress1.end();
        //3、刘佳林
        AbstractWaitressFlyweight waitress2 = ZuDao.getWaitress("");
        System.out.println(waitress2);

    }
}
