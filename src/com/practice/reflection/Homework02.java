package com.practice.reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework02 {
    /**
     * 1.利用Class类的forName方法得到File类的class 对象
     * 2.在控制台打印File类的所有构造器
     * 3.通过newInstance的方法创建File对象，并创建E:\mynew.txt文件
     * 提示:创建文件的正常写法如下:
     * File file = new File(" d:\laa.txt");
     * file.createNewFile();
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        Class<?> cls = Class.forName("java.io.File");
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object o = constructor.newInstance("E:\\mynew.txt");
//        Method createNewFile = cls.getMethod("createNewFile");
//        createNewFile.invoke(o);
        ((File)o).createNewFile();
    }
}
