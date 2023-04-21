package com.shf.design.structural.adapter;

public class MoviePlayer implements Player{
    @Override
    public String play() {
        System.out.println("正在播放：宋老师的宝贵时间.avi");
        String content = "你好";
        System.out.println(content);

        return content;
    }
}
