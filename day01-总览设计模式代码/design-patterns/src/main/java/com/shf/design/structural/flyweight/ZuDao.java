package com.shf.design.structural.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class ZuDao {
    private static Map<String, AbstractWaitressFlyweight> pool = new HashMap<>();

    static {
        BeautifulWaitress beautifulWaitress = new BeautifulWaitress("111", "张三", 18, true);
        BeautifulWaitress beautifulWaitress2 = new BeautifulWaitress("9527", "李四", 20, true);
        pool.put(beautifulWaitress.id, beautifulWaitress);
        pool.put(beautifulWaitress2.id, beautifulWaitress2);
    }

    public void addWaitree(AbstractWaitressFlyweight waitressFlyweight) {
        pool.put(UUID.randomUUID().toString(), waitressFlyweight);
    }

    public static AbstractWaitressFlyweight getWaitress(String name) {
        AbstractWaitressFlyweight flyweight = pool.get(name);
        if (flyweight == null) {
            for (AbstractWaitressFlyweight value : pool.values()) {
                if (value.isCanService()) {
                    return value;
                }
            }
        }
        return null;
    }
}
