package com.shf.design.creatation.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Phone {
    protected String cpu;
    protected String mem;
    protected String disk;
    protected String cam;
}
