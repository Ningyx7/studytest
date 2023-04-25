package com.practice.io_.reader_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReader_ {
    public static void main(String[] args) throws IOException {
        String path="E:\\story.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String str=null;
        while ((str=bufferedReader.readLine())!=null){
            System.out.println(str);
        }
    }
}
