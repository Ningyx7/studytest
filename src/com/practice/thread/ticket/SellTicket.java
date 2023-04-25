package com.practice.thread.ticket;

public class SellTicket {
    /**
     * [售票系统]  编程模拟三个售票窗口售票100张，
     * 分别使用继承Thread和实现Runnable接口的方式，
     * 并分析有什么问题？
     */
    public static void main(String[] args) {
//        new SellTicket01().start();
//        new SellTicket01().start();
//        new SellTicket01().start();
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
    }
}

class SellTicket01 extends Thread {
    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束。。。");
                break;
            }
            System.out.println(Thread.currentThread().getName() + "窗口售出一张票，剩余" + (--ticketNum) + "张票");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SellTicket02 implements Runnable {

    private int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束。。。");
                break;
            }
            System.out.println(Thread.currentThread().getName() + "窗口售出一张票，剩余" + (--ticketNum) + "张票");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
