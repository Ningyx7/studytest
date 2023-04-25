package com.practice.io_.inputstream_;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path="e:\\data.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object object = ois.readObject();
        System.out.println(object);
        //想调用Dog类的方法，必须向下转型，需要导入Dog相应的包
//        Dog dog = (Dog)object;
//        System.out.println(dog);
//        System.out.println(dog.getName());
        ois.close();

    }
}
