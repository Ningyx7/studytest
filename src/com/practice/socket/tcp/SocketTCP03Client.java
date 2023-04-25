package com.practice.socket.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP03Client {
    /**
     * 案例 （使用字符流）
     * 1. 编写一个服务端，和一个客户端
     * 2. 服务端在 9999 端口监听
     * 3. 客户端连接到服务端，发送“hello,server”，并接收服务器端回发的“hello,client”，再退出
     * 4. 服务端接收到客户端发送的信息，输出，并发送"hello,client"，再退出
     * */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("连接成功...");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("hello,server 字符流");
        bw.newLine();
        bw.flush();//注意需要手动的flush
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);

        br.close();
        bw.close();
        socket.close();

    }

}
