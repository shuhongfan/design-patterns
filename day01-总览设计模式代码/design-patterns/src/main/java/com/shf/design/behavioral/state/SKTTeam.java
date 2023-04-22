package com.shf.design.behavioral.state;


public class SKTTeam {
    private TeamState teamState;

    public void setTeamState(TeamState teamState) {
        this.teamState = teamState;
    }

    public void startGame() {
        teamState.playGame();
    }

    //下一个状态
    void nextState(){
        teamState = teamState.next();
    }
}
