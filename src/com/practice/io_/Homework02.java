package com.practice.io_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Homework02 {
    /**
     * 要求:使用BufferedReader读取一个文本文件，为每行加上行号，
     * 再连同内容一并输出到屏幕上。
     */
    public static void main(String[] args) throws IOException {
        String path = "E:\\new1.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String str = "";
        int i=1;
        while ((str = br.readLine()) != null) {
            System.out.println((i++)+":"+str);
        }
        br.close();

    }
}
