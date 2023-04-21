package com.shf.design.prototype;

import lombok.Data;

@Data
public class User implements Cloneable{
    private String username;
    private Integer age;

    public User() {
        System.out.println("user对象创建");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        User user = new User();
        user.setUsername(this.username);
        user.setAge(this.getAge());
        return user;
    }
}
