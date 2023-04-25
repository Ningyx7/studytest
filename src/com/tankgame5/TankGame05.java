package com.tankgame5;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class TankGame05 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        new TankGame05();
    }

    public TankGame05() throws IOException {
        System.out.println("请输入选择： 1.新游戏  2.继续上局游戏");
        String key = scanner.nextLine();
        mp=new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);//把面板（就是游戏的绘图区域）
        this.setSize(1300,800);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame 中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Recorder.keepRecord();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });

    }
}
