package com.practice.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口（画框）
        this.add(mp);
        //设置窗口的大小
        this.setSize(700, 600);
        //当点击窗口的小x，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends Panel {
    //说明：
    //1.MyPanel 对象就是一个画板
    //2.Graphics g 把 g理解成一只画笔
    //3.Graphics 提供了很多绘图的方法
    //Graphics g
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);
        //画出一个圆形
        //g.drawOval(10, 10, 100, 100);

        //绘制不同的图形
        //画直线 drawLine(int x1,int y1,int x2,int y2)
        //g.drawLine(10,10,100,100);
        //画矩形边框 drawRect
        //g.drawRect(10, 10, 100, 100);
        //画椭圆边框 drawOval
        //填充矩形 fillRect
        //设置画笔的颜色
        //g.setColor(Color.CYAN);
        //g.fillRect(10,10,100,100);
        //填充椭圆 fillOval

        //画图片drawImage
        //1.获取图片资源, /pic7.jpg 表示在该项目的根目录去获取 pic7.jpg 图片资源
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/qw.png"));
        g.drawImage(image,10,10,47,47,this);


        //画字符串 drawString
        //设置画笔的字体 setFont
        //设置画笔的颜色 setColor
//        g.setColor(Color.cyan);
//        g.setFont(new Font("隶书", Font.BOLD, 50));
//        g.drawString("北京你好", 100, 100);
        //这里设置的 100，100 是北京你好的左下角

    }
}
