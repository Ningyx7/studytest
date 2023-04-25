package com.practice.socket.download;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileDownServer {
    /**
     * (1)编写客户端程序和服务器端程序
     * (2)客户端可以输入一个音乐文件名，比如高山流水，服务端收到音乐名后，可以给
     * 客户端返回这个音乐文件，如果服务器没有这个文件，返回一个默认的音乐即可.
     * (3)客户端收到文件后，保存到本地e:test
     * (4)提示:该程序可以使用StreamUtils.java
     * 本质:其实就是指定下载文件的应用。
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端9999已启动，正在监听...");
        Socket socket = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String name = br.readLine();
        String fileName = "";
        if ("高山流水".equals(name)) {
            fileName = "高山流水.mp3";
        } else {
            fileName = "Reynard Silva - The Way I Still Love You.mp3";
        }
        File file = new File("src\\", fileName);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bw.write(fileName);
        bw.newLine();
        bw.flush();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = bis.read(buf)) != -1) {
            bos.write(buf,0,readLen);
        }
        bos.flush();
        socket.shutdownOutput();

        bw.close();
        bos.close();
        bis.close();
        br.close();
        socket.close();
        serverSocket.close();

    }
}
