package com.practice.io_.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {
    @Test
    public void readFile01() throws IOException {
        String filePath = "e:\\new1.txt";
        int readData;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        while ((readData = fileInputStream.read()) != -1) {
            System.out.print((char) readData);
        }
        fileInputStream.close();
    }

    @Test
    public void readFile02() throws IOException {
        String filePath = "e:\\new1.txt";
        int readLen=0;
        byte[] buf=new byte[8];
        FileInputStream fileInputStream = new FileInputStream(filePath);
        while ((readLen = fileInputStream.read(buf)) != -1) {
            System.out.print(new String(buf,0,readLen));
        }
        fileInputStream.close();
    }
}
