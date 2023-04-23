package com.shf.design.behavioral.strategy;

import com.atguigu.design.behavioral.strategy.RandomStrategy;

public class MainTest {

    public static void main(String[] args) {

        TeamGNR gnr = new TeamGNR();

        gnr.setGameStrategy(new RandomStrategy());
        gnr.startGame();
    }
}
