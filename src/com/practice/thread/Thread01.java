package com.practice.thread;

public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"线程..."+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Cat extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"线程..."+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

