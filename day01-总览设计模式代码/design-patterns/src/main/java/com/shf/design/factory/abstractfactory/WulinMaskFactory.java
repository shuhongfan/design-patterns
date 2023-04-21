package com.shf.design.factory.abstractfactory;

public abstract class WulinMaskFactory extends WulinFactory{
    @Override
    AbstractCar newCar() {
        return null;
    }


    abstract AbstractMask newMask() ;
}
