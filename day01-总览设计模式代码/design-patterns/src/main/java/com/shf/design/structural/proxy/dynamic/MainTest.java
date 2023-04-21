package com.shf.design.structural.proxy.dynamic;

import com.shf.design.structural.decorator.LeiTikTok;
import com.shf.design.structural.decorator.ManTikTok;
import com.shf.design.structural.proxy.statics.LiMingTikTokProxy;

public class MainTest {
    public static void main(String[] args) {
        ManTikTok leiTikTok = new LeiTikTok();
        ManTikTok proxy = JDKTikTokProxy.getProxy(leiTikTok);
        proxy.tiktok();

        ((SellTikTok)proxy).sell();
    }
}
