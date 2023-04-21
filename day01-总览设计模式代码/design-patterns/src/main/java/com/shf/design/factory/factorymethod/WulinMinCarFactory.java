package com.shf.design.factory.factorymethod;


public class WulinMinCarFactory extends AbstractCatFactory {

    @Override
    public AbstractCar newCar() {
        return new MiniCar();
    }
}
