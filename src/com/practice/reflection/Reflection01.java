package com.practice.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //使用properties类，读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.getProperty("classfullpath");
        String method = properties.getProperty("method");

        //使用反射机制解决
        //1.加载类，返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //2.通过cls得到加载的类 com.practice.reflection.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println(o.getClass());
        //3.通过cls得到加载的类 com.practice.reflection.Cat 的 hi() 方法对象
        //   即：在反射种，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(method);
        //4.通过method1 调用方法  即：通过方法对象来实现调用方法
        method1.invoke(o);

        Field age = cls.getField("age");
        System.out.println("age: "+age);
        System.out.println(age.get(o));

        Constructor constructor = cls.getConstructor();
        System.out.println("constructor: "+constructor);

        Constructor constructor2 = cls.getConstructor(String.class,int.class);
        System.out.println("constructor2: "+constructor2);


    }
}
