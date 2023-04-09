package com.atguigu.design.behavioral.memento;


import java.util.List;
import java.util.Set;

/**
 * 游戏者： 游戏发起人
 * 当前游戏信息
 */
public class LeiGamer {
    Integer coin;//剩余金币
    Integer hp;//血量
    Integer mp;//蓝量

    //保存游戏记录
    void saveGameRecord(){
        System.out.println("正在保存当前记录....");
    }

    //从备忘录获取游戏历史存档
    void getFromMemento(){
        System.out.println("获取历史存档信息....");
    }

    //玩游戏
    void playGame(){
        System.out.println("......(〃'▽'〃)......");
    }

    //退出游戏
    void exitGame(){
        System.out.println("退出&存档");

    }

}
