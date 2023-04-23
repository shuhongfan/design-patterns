package com.shf.design.behavioral.state;

public class MainTest {
    public static void main(String[] args) {
        SKTTeam sktTeam = new SKTTeam();

        VocationState state = new VocationState();
        sktTeam.setTeamState(state);
        sktTeam.startGame();
        sktTeam.nextState();

        sktTeam.startGame();
        sktTeam.nextState();

        sktTeam.startGame();
        sktTeam.nextState();

    }
}
