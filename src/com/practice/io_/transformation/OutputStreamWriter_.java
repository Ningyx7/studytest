package com.practice.io_.transformation;

import java.io.*;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String path = "E:\\ccc1.txt";
        String charset="utf-8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path), charset);
        osw.write("hello,阿松大");
        osw.close();
        System.out.println("按照"+charset+"编码输出成功~");
    }
}
