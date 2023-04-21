package com.shf.design.structural.facade;

public class WeiXinFacade {
    Police police = new Police();
    Edu edu = new Edu();
    Social social = new Social();
    public void handleXxx(String name) {
        police.resqister(name);
        edu.assignSchool(name);
        social.handlerSocial(name);
    }


}
