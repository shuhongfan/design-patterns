package com.shf.design.creatation.factory.abstractfactory;

public class WulinVanCarFactory extends WulinFactory{
    @Override
    AbstractCar newCar() {
        return new VanCar();
    }

    @Override
    AbstractMask newMask() {
        return null;
    }
}
