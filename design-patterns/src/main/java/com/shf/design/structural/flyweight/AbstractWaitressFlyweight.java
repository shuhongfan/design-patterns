package com.shf.design.structural.flyweight;

public abstract class AbstractWaitressFlyweight {
    boolean canService = true;
    abstract void service();

    abstract void end();

    boolean isCanService() {
        return canService;
    }
}
