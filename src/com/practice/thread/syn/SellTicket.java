package com.practice.thread.syn;

public class SellTicket {
    public static void main(String[] args) {
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
    }
}

class SellTicket02 implements Runnable {

    private static int num = 100;
    private boolean loop=true;


    public synchronized void sell(){
        if (num <= 0) {
            System.out.println("售票结束...");
            loop=false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "线程售出一张票，剩余" + (--num) + "张票...");
    }

    @Override
    public void run() {
        while (loop) {
            sell();

        }
    }
}