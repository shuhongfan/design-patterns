package com.shf.design.structural.proxy.statics;


public class LiMingTikTokProxy implements ManTikTok {
    private ManTikTok manTikTok;

    public LiMingTikTokProxy(ManTikTok manTikTok) {
        this.manTikTok = manTikTok;
    }

    @Override
    public void tiktok() {
        System.out.println("渲染直播间");
        System.out.println("武汉丰阳,tiktok...");
        manTikTok.tiktok();
    }
}
