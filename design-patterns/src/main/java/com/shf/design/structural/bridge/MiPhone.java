package com.shf.design.structural.bridge;

public class MiPhone extends AbstractPhone{
    @Override
    String getPhone() {
        return "小米"+sale.getSaleInfo();
    }

}
