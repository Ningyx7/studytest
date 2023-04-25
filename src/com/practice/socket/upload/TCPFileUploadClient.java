package com.practice.socket.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    /**
     * 1.编写一个服务端，和一个客户端
     * 2.服务器端在8888端口监听
     * 3.客户端连接到服务端，发送一张图片e:demo.jpg
     * 4.服务器端接收到客户端发送的图片，保存到src下，发送"收到图片”再退出
     * 5.客户端接收到服务端发送的"收到图片"， 再退出
     * 6.该程序要求使用StreamUtils.java
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        String path = "E:\\demo.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = bis.read(buf)) != -1) {
            bos.write(buf, 0, readLen);
        }
        bos.flush();
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf,0,readLen));
        }

        inputStream.close();
        bos.close();
        bis.close();
        socket.close();

    }
}
