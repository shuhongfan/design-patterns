package com.atguigu.design.creatation.factory.abstractfactory;


/**
 * 具体工厂。只造车
 */
public class WulinRacingCarFactory extends WulinCarFactory {
    @Override
    AbstractCar newCar() {
        return new RacingCar();
    }
}
