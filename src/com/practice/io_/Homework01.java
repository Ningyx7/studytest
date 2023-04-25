package com.practice.io_;

import java.io.*;

public class Homework01 {
    /**
     * (1)在判断e盘下是否有文件夹mytemp ,如果没有就创建mytemp
     * (2)在e：\mytemp目录下，创建文件hello.txt
     * (3)如果hello.txt已经存在，提示该文件已经存在，就不要再重复创建了
     */
    public static void main(String[] args) throws IOException {
        String path="E:\\mytemp";
        File file = new File(path);
        if (!file.exists()) {//目录不存在
            file.mkdir();
        }
        String filePath=path+"\\hello.txt";
        File file1 = new File(filePath);
        if (file1.exists()) {
            System.out.println("文件已存在");
        } else {
            file1.createNewFile();
        }
    }

}
