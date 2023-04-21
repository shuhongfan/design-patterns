package com.shf.design.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Phone {
    protected String cpu;
    protected String mem;
    protected String disk;
    protected String cam;
}
