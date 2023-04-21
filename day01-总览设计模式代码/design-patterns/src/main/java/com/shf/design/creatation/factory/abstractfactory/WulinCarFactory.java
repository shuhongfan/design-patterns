package com.shf.design.creatation.factory.abstractfactory;

public abstract class WulinCarFactory extends WulinFactory {
    @Override
    abstract AbstractCar newCar();

    @Override
    AbstractMask newMask() {
        return null;
    }
}
