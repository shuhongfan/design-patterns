package com.atguigu.design.behavioral.visitor;

public  abstract class Hardware {
    String command;//封装硬件的处理指令

    public Hardware(String command){
        this.command = command;
    }

    public void work(){
        System.out.println(command);
    }

    //定义接受软件升级包的方法。这个方法应该具体硬件去实现
    public abstract void accept(Vistor vistor);
}
