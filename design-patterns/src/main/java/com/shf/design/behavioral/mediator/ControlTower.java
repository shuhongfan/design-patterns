package com.shf.design.behavioral.mediator;


public class ControlTower {
    private boolean canDo = true;

    public void acceptRequest(Captain captain, String action){
        if("fly".equals(action)||"land".equals(action)){
            //
            if(canDo == true){
                System.out.println("允许......");
                canDo = false;
            }else {
                System.out.println("不允许.....");
            }
        }
        if("success".equals(action)){
            canDo = true;
        }


    }
}
