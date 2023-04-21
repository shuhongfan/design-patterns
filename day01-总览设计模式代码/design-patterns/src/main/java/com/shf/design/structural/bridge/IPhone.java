package com.shf.design.structural.bridge;

public class IPhone extends AbstractPhone{
    @Override
    String getPhone() {
        return "IPhone："+sale.getSaleInfo();
    }
}
