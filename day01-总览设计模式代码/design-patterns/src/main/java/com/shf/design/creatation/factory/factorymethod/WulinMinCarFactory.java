package com.shf.design.creatation.factory.factorymethod;


public class WulinMinCarFactory extends AbstractCatFactory {

    @Override
    public AbstractCar newCar() {
        return new MiniCar();
    }
}
