package com.tankgame5;

import java.io.Serializable;
import java.util.Vector;

public class EnemyTank extends Tank implements Runnable, Serializable {
    Vector<Shot> shots = new Vector<>();

    Vector<EnemyTank> enemyTanks = new Vector<>();

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

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

    /**
     * 判断坦克是否重叠
     */
    public boolean isTouchEnemyTank() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank != this) {
                switch (this.getDirect()) {
                    case 0: //上
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //敌人坦克坐标范围  X [ enemyTank.getX() , enemyTank.getX()+40 ]
                            //                 Y [ enemyTank.getY() , enemyTank.getY()+60 ]
                            //当前坦克左上角坐标 [this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //坦克右上角坐标 [this.getX()+40,this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //敌人坦克坐标范围  X [ enemyTank.getX() , enemyTank.getX()+60 ]
                            //                 Y [ enemyTank.getY() , enemyTank.getY()+40 ]
                            //当前坦克左上角坐标 [this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //坦克右上角坐标 [this.getX()+40,this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        break;
                    case 1: //右
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //敌人坦克坐标范围  X [ enemyTank.getX() , enemyTank.getX()+40 ]
                            //                 Y [ enemyTank.getY() , enemyTank.getY()+60 ]
                            //当前坦克右上角坐标 [this.getX()+60,this.getY()]
                            if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //坦克右下角坐标 [this.getX()+60,this.getY()+40]
                            if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //敌人坦克坐标范围  X [ enemyTank.getX() , enemyTank.getX()+60 ]
                            //                 Y [ enemyTank.getY() , enemyTank.getY()+40 ]
                            //当前坦克右上角坐标 [this.getX()+60 , this.getY()]
                            if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //坦克右下角坐标 [this.getX()+60,this.getY()+40]
                            if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        break;
                    case 2: //下
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //敌人坦克坐标范围  X [ enemyTank.getX() , enemyTank.getX()+40 ]
                            //                 Y [ enemyTank.getY() , enemyTank.getY()+60 ]
                            //当前坦克左下角坐标 [this.getX(),this.getY()+60]
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //坦克右下角坐标 [this.getX()+40,this.getY()+60]
                            if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //敌人坦克坐标范围  X [ enemyTank.getX() , enemyTank.getX()+60 ]
                            //                 Y [ enemyTank.getY() , enemyTank.getY()+40 ]
                            //当前坦克左下角坐标 [this.getX() , this.getY()+60]
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //坦克右下角坐标 [this.getX()+40,this.getY()+60]
                            if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        break;
                    case 3: //左
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //敌人坦克坐标范围  X [ enemyTank.getX() , enemyTank.getX()+40 ]
                            //                 Y [ enemyTank.getY() , enemyTank.getY()+60 ]
                            //当前坦克左上角坐标 [this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //坦克左下角坐标 [this.getX(),this.getY()+40]
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //敌人坦克坐标范围  X [ enemyTank.getX() , enemyTank.getX()+60 ]
                            //                 Y [ enemyTank.getY() , enemyTank.getY()+40 ]
                            //当前坦克左上角坐标 [this.getX() , this.getY()]
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //坦克左下角坐标 [this.getX(),this.getY()+40]
                            if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                        break;
                }
            }
        }
        return false;
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
                        if (getY() > 0 && !isTouchEnemyTank()) {
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
                        if (getX() + 60 < 1000 && !isTouchEnemyTank()) {
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
                        if (getY() + 60 < 750 && !isTouchEnemyTank()) {
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
                        if (getX() > 0 && !isTouchEnemyTank()) {
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
