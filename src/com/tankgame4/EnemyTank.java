package com.tankgame4;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();

    private boolean isLive = true;

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public EnemyTank(int x, int y, int direct, int type) {
        super(x, y, direct, type);
    }

    public EnemyTank() {
    }

    @Override
    public void run() {
        while (true) {
            if (!isLive) {//坦克死亡就结束当前坦克线程
                break;
            }
            if (shots.size() < 3) {//敌方坦克的最大子弹数量
                Shot shot = null;
                switch (getDirect()) {
                    case 0:
                        shot = new Shot(getX() + 20, getY(), getDirect());
                        break;
                    case 1:
                        shot = new Shot(getX() + 60, getY() + 20, getDirect());
                        break;
                    case 2:
                        shot = new Shot(getX() + 20, getY() + 60, getDirect());
                        break;
                    case 3:
                        shot = new Shot(getX(), getY() + 20, getDirect());
                        break;
                }
                new Thread(shot).start();
                shots.add(shot);
            }

            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            //随机改变敌方坦克的移动方向
            setDirect((int) (Math.random() * 4));
        }
    }
}
