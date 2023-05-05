package com.atguigu.redis;

import com.atguigu.data.DataSaveService;

import java.util.ServiceLoader;


/**
 * 1、 ServiceLoader：load（）指定一个接口，
 *      他就会加载当前系统里面所有的这个接口的【指定实现】
 * 2、SPI（Service Provider Interface）
 *      接口工程---提供接口
 *          ---- 实现工程1  ： 实现接口 【META-INF/services 创建文件  接口名作为文件名  实现类全路径作为文件内容】
 *          ---- 实现工程2  ： 实现接口
 *
 *
 *      客户端----引用 工程1、或者 工程2
 *
 *
 *
 */
public class MainTest {

    public static void main(String[] args) {

        //1、加载 可用的接口实现
        ServiceLoader<DataSaveService> load = ServiceLoader.load(DataSaveService.class);

        //拿到实现进行调用
        for (DataSaveService service : load) {
            service.saveData("你好....");
        }

    }
}
