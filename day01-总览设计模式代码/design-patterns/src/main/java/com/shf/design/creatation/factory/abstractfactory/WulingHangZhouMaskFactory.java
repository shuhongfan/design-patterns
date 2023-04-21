package com.shf.design.creatation.factory.abstractfactory;


public class WulingHangZhouMaskFactory extends WulinFactory {
    @Override
    AbstractCar newCar() {
        return null;
    }

    @Override
    AbstractMask newMask() {
        return new CommonMask();
    }
}
