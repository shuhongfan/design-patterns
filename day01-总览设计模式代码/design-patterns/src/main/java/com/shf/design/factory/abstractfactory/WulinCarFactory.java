package com.shf.design.factory.abstractfactory;

public abstract class WulinCarFactory extends WulinFactory {
    @Override
    abstract AbstractCar newCar();

    @Override
    AbstractMask newMask() {
        return null;
    }
}
