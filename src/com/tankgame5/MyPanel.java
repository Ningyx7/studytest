package com.tankgame5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

//为了监听 键盘事件， 实现KeyListener
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    private int enemyTanksSize = 3;//初始敌方坦克数量

    Vector<Bomb> bombs = new Vector<>();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(String key) throws IOException {
        if ("2".equals(key)) {
            File file = new File(Recorder.getRecordFile());
            if (!file.exists()) {
                System.out.println("上局记录不存在，新建游戏~");
                key="1";
            }
        }
        switch (key) {
            case "1"://新游戏
                Recorder.setEnemyTanks(enemyTanks);//用于存档
                hero = new Hero(500, 100, 0, 1);//初始化自己坦克
                //初始化敌方坦克和子弹
                for (int i = 0; i < enemyTanksSize; i++) {
                    EnemyTank enemyTank = new EnemyTank((i + 1) * 100, 0, 2, 0);
                    enemyTank.setEnemyTanks(enemyTanks);
                    Shot shot = new Shot(enemyTank.getX() + 18, enemyTank.getY() + 60, enemyTank.getDirect());
                    enemyTank.shots.add(shot);
                    new Thread(enemyTank).start();
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }
                break;
            case "2"://继续上局游戏
                Recorder.setEnemyTanks(enemyTanks);//用于存档
                Vector<Node> nodes = Recorder.getNodesEnemyTankRec();

                hero = new Hero(500, 100, 0, 1);//初始化自己坦克
                //初始化敌方坦克和子弹
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY(), node.getDirect(), 0);
                    enemyTank.setEnemyTanks(enemyTanks);
                    Shot shot = new Shot(enemyTank.getX() + 18, enemyTank.getY() + 60, enemyTank.getDirect());
                    enemyTank.shots.add(shot);
                    new Thread(enemyTank).start();
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }
                break;
            default:
                System.out.println("输入有误");
        }

        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

        new AePlayWave("src\\111.wav").start();

    }

    //编写方法，显示我方击毁敌方坦克的信息
    public void showInfo(Graphics g) {
        //画出玩家的总成绩
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("您累积击毁敌方坦克", 1020, 30);
        drawTank(1020, 60, g, 0, 0);
        g.setColor(Color.black);
        g.drawString(Recorder.getAllEnemyTankNum() + "", 1080, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        showInfo(g);//画出记录的信息

        //画出坦克-封装方法
        if (hero != null && hero.isLive()) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), hero.getType());
        }

        //画我方坦克子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot == null || !shot.isLive()) {
                hero.shots.remove(shot);
            } else if (shot != null && shot.isLive()) {
                g.setColor(Color.yellow);//设置子弹颜色和坦克颜色相同
                g.fillOval(shot.getX(), shot.getY(), 5, 5);
            }
        }

        //绘制敌方坦克和子弹
        for (EnemyTank enemyTank : enemyTanks) {
            if (enemyTank.isLive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), enemyTank.getType());
            }
            for (int i = 0; i < enemyTank.shots.size(); i++) {
                Shot shot = enemyTank.shots.get(i);
                if (shot.isLive()) {
                    g.setColor(Color.cyan);//设置子弹颜色和坦克颜色相同
                    g.fillOval(shot.getX(), shot.getY(), 5, 5);
                } else {
                    enemyTank.shots.remove(shot);
                }
            }
        }

        //如果bombs中有对象，就画出爆炸
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();//让炸弹的生命值减少
            //如果bomb life 为0, 就从bombs 的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }

        }


    }

    //编写方法，画出坦克

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0: //敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //我们的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制坦克
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }

    //编写方法，判断我方子弹是否击中敌方坦克
    public void hitEnemyTank(Vector<Shot> shots, Vector<EnemyTank> enemyTanks) {
        for (int i = 0; i < shots.size(); i++) {
            Shot shot = shots.get(i);
            for (int j = 0; j < enemyTanks.size(); j++) {
                EnemyTank enemyTank = enemyTanks.get(j);
                switch (enemyTank.getDirect()) {
                    case 0:
                    case 2:
                        if (shot.getX() > enemyTank.getX() && shot.getX() < enemyTank.getX() + 40
                                && shot.getY() > enemyTank.getY() && shot.getY() < enemyTank.getY() + 60) {
                            shot.setLive(false);
                            enemyTank.setLive(false);
                            enemyTanks.remove(enemyTank);
                            Recorder.addAllEnemyTankNum();
                            Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                            bombs.add(bomb);
                        }
                        break;
                    case 1:
                    case 3:
                        if (shot.getX() > enemyTank.getX() && shot.getX() < enemyTank.getX() + 60
                                && shot.getY() > enemyTank.getY() && shot.getY() < enemyTank.getY() + 40) {
                            shot.setLive(false);
                            enemyTank.setLive(false);
                            enemyTanks.remove(enemyTank);
                            Recorder.addAllEnemyTankNum();
                            Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                            bombs.add(bomb);
                        }
                        break;
                }
            }
        }
    }

    //编写方法，判断我方坦克是否被敌方坦克击中
    public void hitHeroTank(Vector<Shot> shots, Tank hero) {
        Hero tank = (Hero) hero;
        if (!tank.isLive()) {
            return;
        }
        for (int i = 0; i < shots.size(); i++) {
            Shot shot = shots.get(i);
            switch (tank.getDirect()) {
                case 0:
                case 2:
                    if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 40
                            && shot.getY() > tank.getY() && shot.getY() < tank.getY() + 60) {
                        shot.setLive(false);
                        tank.setLive(false);
                        Bomb bomb = new Bomb(tank.getX(), tank.getY());
                        bombs.add(bomb);
                    }
                    break;
                case 1:
                case 3:
                    if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 60
                            && shot.getY() > tank.getY() && shot.getY() < tank.getY() + 40) {
                        shot.setLive(false);
                        tank.setLive(false);
                        Bomb bomb = new Bomb(tank.getX(), tank.getY());
                        bombs.add(bomb);
                    }
                    break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (hero.getY() > 0) {
                hero.setDirect(0);
                hero.moveUp();
                this.repaint();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (hero.getX() + 60 < 1000) {
                hero.setDirect(1);
                hero.moveRight();
                this.repaint();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (hero.getY() + 60 < 750) {
                hero.setDirect(2);
                hero.moveDown();
                this.repaint();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (hero.getX() > 0) {
                hero.setDirect(3);
                hero.moveLeft();
                this.repaint();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            if (hero.isLive()) {
                hero.shotEnemyTank();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitEnemyTank(hero.shots, enemyTanks);
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                hitHeroTank(enemyTank.shots, hero);
            }
            this.repaint();
        }
    }
}
