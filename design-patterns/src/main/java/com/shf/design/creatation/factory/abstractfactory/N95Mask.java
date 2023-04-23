package com.shf.design.creatation.factory.abstractfactory;

public class N95Mask extends AbstractMask{
    public N95Mask() {
        this.price = 2;
    }

    @Override
    public void protectedMe() {
        System.out.println("N95口罩...超级防护");
    }
}
