package com.shf.design.structural.decorator;

public class MainTest {
    public static void main(String[] args) {
        LeiTikTok leiTikTok = new LeiTikTok();
        leiTikTok.tiktok();

        MeiYanDecorator decorator = new MeiYanDecorator(leiTikTok);
        decorator.tiktok();
    }
}
