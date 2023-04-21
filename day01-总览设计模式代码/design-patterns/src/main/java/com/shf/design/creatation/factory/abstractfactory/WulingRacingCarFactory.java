package com.shf.design.creatation.factory.abstractfactory;

public class WulingRacingCarFactory extends WulinFactory{
    @Override
    AbstractCar newCar() {
        return new RacingCar();
    }

    @Override
    AbstractMask newMask() {
        return null;
    }
}
