package com.practice.io_.outputstream_;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStream_ {
    @Test
    public void writer01() throws IOException {
        String filePath="e:\\a\\a.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        String str="qwe66";
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }
}
