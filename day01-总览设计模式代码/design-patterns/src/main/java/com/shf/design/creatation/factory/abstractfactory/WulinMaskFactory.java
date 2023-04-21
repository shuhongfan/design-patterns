package com.shf.design.creatation.factory.abstractfactory;

public abstract class WulinMaskFactory extends WulinFactory{
    @Override
    AbstractCar newCar() {
        return null;
    }


    abstract AbstractMask newMask() ;
}
