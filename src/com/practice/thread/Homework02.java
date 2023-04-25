package com.practice.thread;

public class Homework02 {
    /**
     * 1.有2个用户分别从同一个卡上取钱（总额：10000）
     * 2.每次都取1000，当余额不足时，就不能取钱了
     * 3.不能出现超取现象
     */
    public static void main(String[] args) {
        Ta ta = new Ta();
        Thread thread1 = new Thread(ta);
        Thread thread2 = new Thread(ta);
        thread1.setName("用户1");
        thread2.setName("用户2");
        thread1.start();
        thread2.start();

    }
}

class Ta implements Runnable {
    private int count = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (count < 1000) {
                    System.out.println("余额不足...");
                    return;
                }
                count -= 1000;
                System.out.println(Thread.currentThread().getName() + "取钱1000元  余额：" + count);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



