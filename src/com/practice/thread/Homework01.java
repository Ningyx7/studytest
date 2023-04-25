package com.practice.thread;


import java.util.Scanner;

public class Homework01 {
    /**
     * 1.在main方法中启动两个线程
     * 2.第1个线程循环随机打印100以内的整数
     * 3.直到第2个线程从键盘读取了“Q”命令
     */
    public static void main(String[] args) {
        new Thread(new HomeThread01()).start();
        new Thread(new HomeThread02()).start();
    }
}

class HomeThread01 implements Runnable {
    private static boolean loop = true;

    public static boolean isLoop() {
        return loop;
    }

    public static void setLoop(boolean loop) {
        HomeThread01.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            System.out.println((int) (Math.random() * 100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HomeThread02 implements Runnable {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            System.out.println("输入Q停止打印：");
            String s = scanner.nextLine();
            if ("Q".equals(s)) {
                HomeThread01.setLoop(false);
                break;
            }
        }
    }
}