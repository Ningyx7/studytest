package com.practice.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        // 1.连接服务端（IP，端口）
        // 解读：连接本机的9999端口，如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
        System.out.println("连接成功...");
        // 2.连接上后，生成Socket，通过socket.getOutputStream()
        //    得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        // 3.通过输出流，写入数据到数据通道
        outputStream.write("hello,你好".getBytes());
        // 4.关闭流对象和socket，必须关闭
        outputStream.close();
        socket.close();
    }
}
