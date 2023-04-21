package com.shf.design.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class BeautifulWaitress extends AbstractWaitressFlyweight{
    String id;
    String name;
    int age;

    boolean canService = true;


    @Override
    void service() {
        System.out.println("工号：" + id + ";" + name + ";" + age + "正在为您服务");
        this.canService = false;
    }

    @Override
    void end() {
        System.out.println("工号：" + id + ";" + name + ";" + age + "正在为您服务");
        this.canService = true;
    }
}
