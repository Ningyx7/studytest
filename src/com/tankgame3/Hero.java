package com.tankgame3;

public class Hero extends Tank {
    Shot shot = null;

    public Hero(int x, int y, int direct, int type) {
        super(x, y, direct, type);
    }

    public Hero() {
    }

    public void shotEnemyTank() {
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
        new Thread(shot).start();

    }

}
