package com.practice.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Server {
    /**
     * (1)使用字符流的方式，编写一个客户端程序和服务器端程序，
     * (2)客户端发送”name",服务器端接收到后，返回"我是nova， nova是你自己的名字.
     * (3)客户端发送"hobby",服务器端接收到后，返回"编写java程序"
     * (4)不是这两个问题，回复"你说啥呢"
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String s = br.readLine();
        System.out.println(s);
        if("name".equals(s)){
            bw.write("我是nova");
        }else if("hobby".equals(s)){
            bw.write("编写java程序");
        }else {
            bw.write("你说啥呢");
        }
        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();

    }
}
