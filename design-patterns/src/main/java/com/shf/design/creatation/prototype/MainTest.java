package com.shf.design.creatation.prototype;

/**
 * 用于创建重复的对象，同时又能保证性能
 */
public class MainTest {
    public static void main(String[] args) {
        GuiguMybatis guiguMybatis = new GuiguMybatis();

        User zhangsan1 = guiguMybatis.getUser("张三");
        zhangsan1.setUsername("李四");
        System.out.println(zhangsan1);

        User zhangsan2 = guiguMybatis.getUser("张三");
        System.out.println(zhangsan2);

        User zhangsan3 = guiguMybatis.getUser("张三");
        System.out.println(zhangsan3);

        User zhangsan4 = guiguMybatis.getUser("张三");
        System.out.println(zhangsan4);
    }
}
