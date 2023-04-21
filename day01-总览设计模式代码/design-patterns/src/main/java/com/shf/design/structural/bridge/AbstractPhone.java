package com.shf.design.structural.bridge;

public abstract class AbstractPhone {
//    桥接
    AbstractSale sale;

//    abstract int getPrince();

    abstract String getPhone();

    public void setSale(AbstractSale sale) {
        this.sale = sale;
    }
}
