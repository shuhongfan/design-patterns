package com.shf.design.factory.abstractfactory;

public class CommonMask extends AbstractMask{
    public CommonMask() {
        this.price = 1;
    }

    @Override
    public void protectedMe() {
        System.out.println("普通口罩...简单防护");
    }
}
