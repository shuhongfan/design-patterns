package com.atguigu.design.behavioral.visitor;

public class CPU  extends Hardware{
    public CPU(String command) {
        super(command);
    }

    @Override
    public void accept(Vistor vistor) {
        //软件包要能访问当前硬件
        vistor.visitCPU(this);
    }
}
