package com.practice.io_.writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String path="E:\\new1.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path,true));
        bufferedWriter.write("你好");
        bufferedWriter.newLine();//换行
        bufferedWriter.write("666");
        bufferedWriter.newLine();
        bufferedWriter.write("hello");
        bufferedWriter.close();
        System.out.println("输出成功~");
    }
}
