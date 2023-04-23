package com.shf.design.creatation.factory.simplefactory;

public class MainTest {
    public static void main(String[] args) {
        WuLinSimpleFactroy wuLinSimpleFactroy = new WuLinSimpleFactroy();

        AbstractCar van = wuLinSimpleFactroy.newCar("van");
        AbstractCar mini = wuLinSimpleFactroy.newCar("mini");
        AbstractCar zz = wuLinSimpleFactroy.newCar("zz");
        System.out.println(van);
        System.out.println(mini);
        System.out.println(zz);
    }
}
