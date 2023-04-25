package com.practice.io_.reader_;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {
        char[] buf = new char[8];
        int readLen = 0;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("E:\\story.txt");
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
