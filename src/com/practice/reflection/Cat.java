package com.practice.reflection;

public class Cat {
    private String name="汤姆猫";

    public int age = 10;

    public Cat() {
    }

    public Cat(int age) {
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hi(){
        //System.out.println("hi "+name);
    }

}
