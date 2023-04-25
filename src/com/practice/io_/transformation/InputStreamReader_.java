package com.practice.io_.transformation;

import java.io.*;

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String path = "E:\\new1.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        System.out.println(s);
        br.close();
    }
}
