package com.practice.jihe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Homework02 {
    /**
     * 1.使用HashMap类实例化一个Map类型的对象m，键（String）和值（int）
     * 分别用于存储员工的姓名和工资，存入数据如下： jack——650元；tom——1200元，smith——2900元
     * 2.将Jack的工资更改为2600元
     * 3.为所有员工工资加薪100元
     * 4.遍历集合中所有的员工
     * 5.遍历集合中所有的工资
     */
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack",650);
        m.put("tom",1200);
        m.put("smith",2900);
        System.out.println("初始化后："+m);
        System.out.println("将jack的工资修改为2600元--------");
        m.put("jack", 2600);
        System.out.println(m);
        Set set = m.keySet();
        for (Object key : set) {
            Integer value = (Integer)m.get(key);
            value+=100;
            m.put(key,value);
        }
        System.out.println("为所有员工加薪100元-----------");
        System.out.println(m);
        System.out.println("遍历所有的员工");
        for (Object key : set) {
            System.out.println(key);
        }
        System.out.println("遍历所有的工资--------------");
        Set entrySet = m.entrySet();
        for (Object entry : entrySet) {
            System.out.println(((Map.Entry) entry).getValue());
        }


    }
}
