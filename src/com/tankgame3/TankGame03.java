package com.tankgame3;

import javax.swing.*;

public class TankGame03 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {
        new TankGame03();
    }

    public TankGame03(){
        mp=new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);//把面板（就是游戏的绘图区域）
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
