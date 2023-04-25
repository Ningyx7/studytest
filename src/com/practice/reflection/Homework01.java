package com.practice.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework01 {
    /**
     * 1.定义PrivateTest类， 有私有name属性，并且属性值为hellokitty
     * 2.提供getName的公有方法
     * 3.创建Private Test的类，利用Class类得到私有的name属性，修改私有的name属性值，
     * 并调用getName(的方法打印name属性值
     */

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("com.practice.reflection.PrivateTest");
        Object o = cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"tom");
        Method getName = cls.getMethod("getName");
        System.out.println(getName.invoke(o));
    }

}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }
}
