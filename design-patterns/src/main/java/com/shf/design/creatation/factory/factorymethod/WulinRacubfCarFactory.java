package com.shf.design.creatation.factory.factorymethod;


public class WulinRacubfCarFactory extends AbstractCatFactory{

    @Override
    public AbstractCar newCar() {
        return new RacingCar();
    }
}
