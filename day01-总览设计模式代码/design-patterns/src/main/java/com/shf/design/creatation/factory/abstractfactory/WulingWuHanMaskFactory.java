package com.shf.design.creatation.factory.abstractfactory;

public class WulingWuHanMaskFactory extends WulinFactory{
    @Override
    AbstractCar newCar() {
        return null;
    }

    @Override
    AbstractMask newMask() {
        return new N95Mask();
    }
}
