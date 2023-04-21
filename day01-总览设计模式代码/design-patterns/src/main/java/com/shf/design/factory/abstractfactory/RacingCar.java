package com.shf.design.factory.abstractfactory;

public class RacingCar extends AbstractCar {
    public RacingCar() {
        this.engine = "V8发动机";
    }

    @Override
    public void run() {
        System.out.println(engine+" 飕飕");
    }
}
