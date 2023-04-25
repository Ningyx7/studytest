package com.practice.thread;

public class Test1 {
    public static void main(String[] args) {
        int[] arr= new int[]{8,6,2,7,4,10};
        for (int i = 0; i < arr.length; i++) {
            T t = new T();
            t.num=arr[i];
            Thread thread = new Thread(t);
            thread.start();
        }
    }
}
class T implements Runnable{

    int num;

    @Override
    public void run() {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }

}
