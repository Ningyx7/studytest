package com.practice.io_.outputstream_;

import java.io.*;

public class BufferedOutputCopy_ {
    //字节处理流拷贝文件
    public static void main(String[] args) {
        String srcPath = "E:\\new1.txt";
        String destPath = "E:\\new2.txt";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcPath));
            bos = new BufferedOutputStream(new FileOutputStream(destPath));
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = bis.read(buf)) != -1) {
                bos.write(buf, 0, readLen);
            }
            System.out.println("拷贝成功~");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (bis!=null) {
                    bis.close();
                }
                if (bos!=null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
