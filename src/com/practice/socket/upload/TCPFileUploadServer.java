package com.practice.socket.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    /**
     * 1.编写一个服务端，和一个客户端
     * 2.服务器端在8888端口监听
     * 3.客户端连接到服务端，发送一张图片e:demo.jpg
     * 4.服务器端接收到客户端发送的图片，保存到src下，发送"收到图片”再退出
     * 5.客户端接收到服务端发送的"收到图片"， 再退出
     * 6.该程序要求使用StreamUtils.java
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听，等待连接...");
        Socket socket = serverSocket.accept();
        String path = "src\\demo1.jpg";

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = bis.read(buf)) != -1) {
            bos.write(buf,0,readLen);
        }
        bos.flush();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务器收到图片".getBytes());
        outputStream.flush();
        socket.shutdownOutput();

        outputStream.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();

    }

}
