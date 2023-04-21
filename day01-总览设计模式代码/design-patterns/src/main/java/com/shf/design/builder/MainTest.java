package com.shf.design.builder;

public class MainTest {
    public static void main(String[] args) {
        XiaoMiBuilder xiaoMiBuilder = new XiaoMiBuilder();

        Phone product = xiaoMiBuilder.customMem("16G")
                .customDisk("1T")
                .customCam("2亿")
                .customCpu("16核")
                .getProduct();
        System.out.println(product);
    }
}
