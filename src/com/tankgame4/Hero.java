package com.tankgame4;

import java.util.Vector;

public class Hero extends Tank {
    private boolean isLive=true;
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public Hero(int x, int y, int direct, int type) {
        super(x, y, direct, type);
    }

    public Hero() {
    }

    public void shotEnemyTank() {
        if (shots.size() >= 5) {
            return;
        }
        switch (getDirect()) {
            case 0:
                shot = new Shot(getX() + 18, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY() + 18, 1);
                break;
            case 2:
                shot = new Shot(getX() + 18, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY() + 18, 3);
                break;
        }
        shots.add(shot);
        new Thread(shot).start();

    }

}
