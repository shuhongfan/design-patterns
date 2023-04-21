package com.shf.design.creatation.factory.factorymethod;


public class MainTest {
    public static void main(String[] args) {
        AbstractCatFactory catFactory = new WulinRacubfCarFactory();
        AbstractCar abstractCar = catFactory.newCar();
        abstractCar.run();

        catFactory = new WulinMinCarFactory();
        abstractCar = catFactory.newCar();
        abstractCar.run();
    }
}
