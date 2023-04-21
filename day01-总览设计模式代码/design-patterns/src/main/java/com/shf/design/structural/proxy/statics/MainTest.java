package com.shf.design.structural.proxy.statics;


public class MainTest {
    public static void main(String[] args) {
        LiMingTikTokProxy proxy = new LiMingTikTokProxy(new LeiTikTok());
        proxy.tiktok();
    }
}
