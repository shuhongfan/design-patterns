package com.shf.design.creatation.factory.factorymethod;


public class WulinVanCarFactory extends AbstractCatFactory{
    @Override
    public AbstractCar newCar() {
        return new VanCar();
    }
}
