package com.practice.io_.writer;

import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) {
        String srcPath = "E:\\story.txt";
        String destPath = "E:\\aaa1.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(srcPath));
            bufferedWriter = new BufferedWriter(new FileWriter(destPath));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();//换行
            }
            System.out.println("拷贝成功~");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (bufferedReader!=null) {
                    bufferedReader.close();
                }
                if(bufferedWriter!=null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
