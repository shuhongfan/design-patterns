package com.shf.design.structural.proxy.dynamic;

import com.shf.design.structural.decorator.ManTikTok;

public class LeiTikTok implements ManTikTok,SellTikTok {
    @Override
    public void tiktok() {
        System.out.println("雷丰阳，tiktok...");
    }

    @Override
    public void sell() {
        System.out.println("雷丰阳，只要666");
    }

    public void haha() {
        System.out.println("hahahhshs,....");
    }
}
