package com.shf.design.structural.proxy.cglib;

public class CglibTest {
    public static void main(String[] args) {
        LeiTikTok leiTikTok = new LeiTikTok();
        LeiTikTok proxy = CglibProxy.createProxy(leiTikTok);
        proxy.tiktokHaha();
    }
}
