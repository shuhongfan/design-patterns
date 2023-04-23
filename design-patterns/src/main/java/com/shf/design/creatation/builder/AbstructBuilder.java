package com.shf.design.creatation.builder;

public abstract class AbstructBuilder {
    Phone phone;

    abstract AbstructBuilder customCpu(String cpu);
    abstract AbstructBuilder customMem(String mem);
    abstract AbstructBuilder customDisk(String disk);
    abstract AbstructBuilder customCam(String cam);

    Phone getProduct() {
        return phone;
    }
}
