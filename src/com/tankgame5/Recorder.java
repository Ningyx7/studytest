package com.tankgame5;

import java.io.*;
import java.util.Vector;

@SuppressWarnings({"all"})
public class Recorder {
    //定义变量，记录我方击毁敌人坦克数
    private static int allEnemyTankNum = 0;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static ObjectOutputStream oos = null;
    private static String recordFile = "src\\myRecord.txt";
    private static Vector<EnemyTank> enemyTanks = null;
    private static Vector<Node> nodes = new Vector<>();

    public static String getRecordFile() {
        return recordFile;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //当我方坦克击毁一个敌人坦克，就应当 allEnemyTankNum++
    public static void addAllEnemyTankNum() {
        Recorder.allEnemyTankNum++;
    }

    //增加一个方法，用户读取recordFile,恢复相关信息
    //该方法，在继续上局的时候调用
    public static Vector<Node> getNodesEnemyTankRec() throws IOException {
        br = new BufferedReader(new FileReader(recordFile));
        allEnemyTankNum = Integer.valueOf(br.readLine());
        String str = "";
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            Node node = new Node(Integer.valueOf(s[0]), Integer.valueOf(s[1]), Integer.valueOf(s[2]));
            nodes.add(node);
        }
        return nodes;
    }

    //增加一个方法，当游戏退出时，我们将allEnemyTankNum 保存到 recordFile
    //对keepRecord 进行升级, 保存敌人坦克的坐标和方向
    public static void keepRecord() throws IOException {
        bw = new BufferedWriter(new FileWriter(recordFile));
        bw.write(allEnemyTankNum + "\r\n");
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive()) {
                bw.write(enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect() + "\r\n");
                //oos = new ObjectOutputStream(new FileOutputStream(recordFile));
                //oos.writeObject(enemyTanks);
            }
        }
        if (oos != null) {
            oos.close();
        }
        if (bw != null) {
            bw.close();
        }
    }

}
