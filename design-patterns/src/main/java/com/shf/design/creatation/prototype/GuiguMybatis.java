package com.shf.design.creatation.prototype;

import lombok.SneakyThrows;

import java.util.HashMap;

public class GuiguMybatis {
    HashMap<String, User> userCache = new HashMap<>();


    @SneakyThrows
    public User getUser(String username) {
        User user = null;
        if (!userCache.containsKey(username)) {
//            查询数据库
            user = getUserFromDB(username);
        } else {
//            从缓存直接拿，脏缓存问题
//            原型已经拿到，但是不能直接给
            user = userCache.get(username);
//            从这个对象快速得到一个克隆体===原型模式
            user = (User) user.clone();
        }
        return user;
    }

    @SneakyThrows
    private User getUserFromDB(String username) {
        System.out.println("从数据库查 " + username);
        User user = new User();
        user.setUsername(username);
        user.setAge(18);

        userCache.put(username, (User) user.clone());
        return user;
    }
}
