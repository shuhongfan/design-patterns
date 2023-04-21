package com.shf.design.structural.bridge;

public abstract class AbstractSale {
    private String type;
    private Integer price;

    public AbstractSale(String type, Integer price) {
        this.type = type;
        this.price = price;
    }

    String getSaleInfo() {
        return "渠道：" + type + "===> 价格：" + price;
    }

}
