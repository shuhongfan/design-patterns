package com.atguigu.design.behavioral.visitor;

/**
 * 升级包可以更改指令
 */
public class UpdatePackage implements Vistor{
    @Override
    public void visitCPU(CPU cpu) {
        cpu.command+="；正在联网查询...";
    }

    @Override
    public void visitDisk(Disk disk) {
        disk.command+="；正在保存记录";
    }
}
