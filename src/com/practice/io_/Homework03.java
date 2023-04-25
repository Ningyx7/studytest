package com.practice.io_;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /**
         *  1.编写一个dog.properties
         *    name=tom
         *    age=5
         *    color=red
         *  2.编写Dog类（name,age,color） 创建一个dog对象，读取dog.properties
         *    用相应的内容完成属性初始化，并输出
         *  3.将创建的Dog对象，序列化到文件 dog.dat
         * */
        String path="src\\dog.properties";
        String destPath="E:\\dog.dat";
        Properties properties = new Properties();
        properties.load(new FileReader(path));
        Dog dog = new Dog();
        dog.setName(properties.getProperty("name"));
        dog.setAge(Integer.valueOf(properties.getProperty("age")));
        dog.setColor(properties.getProperty("color"));
        System.out.println(dog);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destPath));
        oos.writeObject(dog);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(destPath));
        Object object = ois.readObject();
        ois.close();
        dog=(Dog)object;
        System.out.println(dog);

    }
}
class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Dog() {
    }

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
