package com.shf.design.creatation.factory.simplefactory;

/**
 * 简单工厂
 * 1. 产品数量少
 */
public class WuLinSimpleFactroy {
    public AbstractCar newCar(String type) {
        if ("van".equals(type)) {
            return new VanCar();
        } else if ("mini".equals(type)){
            return new MiniCar();
        }
        return null;
    }
}
