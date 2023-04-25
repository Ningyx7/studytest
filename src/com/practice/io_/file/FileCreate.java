package com.practice.io_.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    @Test
    public void create01(){  //new File(String pathname)  //根据路径构建一个File对象
        String filePath="G:\\new1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create02(){ //new File(File parent,String chile) //根据父目录文件和子路径创建文件
        File file = new File("E:\\");
        File file1 = new File(file, "new2.txt");
        try {
            file1.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create03(){  //new File(String parent,String child) //根据父目录+子路径构建
        File file = new File("e:/", "new3.txt");
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
