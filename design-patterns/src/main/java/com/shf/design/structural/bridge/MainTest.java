package com.shf.design.structural.bridge;

public class MainTest {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone();
//        iPhone.setSale(new OfflineSale("线下", 9999));
        iPhone.setSale(new StudentSale("学生", 6999));

        System.out.println(iPhone.getPhone());
    }
}
