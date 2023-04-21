package com.shf.design.builder;

public class XiaoMiBuilder extends AbstructBuilder{
    public XiaoMiBuilder() {
        phone = new Phone();
    }

    @Override
    AbstructBuilder customCpu(String cpu) {
        phone.cpu = cpu;
        return this;
    }

    @Override
    AbstructBuilder customMem(String mem) {
        phone.mem =mem;
        return this;
    }

    @Override
    AbstructBuilder customDisk(String disk) {
        phone.disk = disk;
        return this;
    }

    @Override
    AbstructBuilder customCam(String cam) {
        phone.cam = cam;
        return this;
    }
}
