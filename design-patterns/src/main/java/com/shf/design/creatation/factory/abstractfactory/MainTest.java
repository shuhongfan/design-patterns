package com.shf.design.creatation.factory.abstractfactory;

public class MainTest {
    public static void main(String[] args) {
        WulinFactory wulinFactory = new WulingWuHanMaskFactory();
        AbstractCar abstractCar = wulinFactory.newCar();

        AbstractMask abstractMask = wulinFactory.newMask();
        abstractMask.protectedMe();

        wulinFactory = new WulingHangZhouMaskFactory();
        AbstractMask abstractMask1 = wulinFactory.newMask();
        abstractMask1.protectedMe();
    }
}
