package com.atguigu.redis;

import com.atguigu.data.DataSaveService;

public class RedisSaveService implements DataSaveService {
    @Override
    public void saveData(String data) {
        System.out.println("Redis保存了数据......."+data);
    }
}
