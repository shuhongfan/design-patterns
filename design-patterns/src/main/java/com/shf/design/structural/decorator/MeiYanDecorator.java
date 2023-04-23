package com.shf.design.structural.decorator;

public class MeiYanDecorator implements TiktokDecorator{
    private ManTikTok manTikTok;

    public MeiYanDecorator(ManTikTok manTikTok) {
        this.manTikTok = manTikTok;
    }

    @Override
    public void tiktok() {
//        开启美颜
        enable();
        manTikTok.tiktok();
    }


    @Override
    public void enable() {
        System.out.println("看这个美女...");
        System.out.println("花花花花花");
    }
}
