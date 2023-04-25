package com.practice.io_.outputstream_;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileCopy_ {
    /**
     * 文件拷贝 将E:\a\pic2.jpg 拷贝到E:\b下
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\a\\pic2.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\b\\pic3.jpg");
        byte[] buf = new byte[8];
        int readLen = 0;
        while ((readLen = fileInputStream.read(buf)) != -1) {
            fileOutputStream.write(buf,0,readLen);
        }
        System.out.println("拷贝成功");
        fileInputStream.close();
        fileOutputStream.close();
    }
}
