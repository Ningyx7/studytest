package com.practice.io_.outputstream_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        String path="E:\\data.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeInt(100);//int -> Integer(实现了 Serializable)
        oos.writeBoolean(true);
        oos.writeChar('a');
        oos.writeDouble(9.9);
        oos.writeUTF("hello高斯林");
        oos.writeObject(new Dog("大黄",10));//保存的对象必须实现序列化接口
        oos.close();
        System.out.println("数据保存完毕（序列化）");

    }
}
