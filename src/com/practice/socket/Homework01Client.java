package com.practice.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Homework01Client {
    /**
     * (1)使用字符流的方式，编写一个客户端程序和服务器端程序，
     * (2)客户端发送”name",服务器端接收到后，返回"我是nova "， nova是你自己的名字.
     * (3)客户端发送"hobby",服务器端接收到后，返回"编写java程序"
     * (4)不是这两个问题，回复"你说啥呢"
     * */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("hobby1");
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println("server的恢复："+s);

    }
}
