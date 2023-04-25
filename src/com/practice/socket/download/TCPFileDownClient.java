package com.practice.socket.download;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPFileDownClient {
    /**
     * (1)编写客户端程序和服务器端程序
     * (2)客户端可以输入一个音乐文件名，比如高山流水，服务端收到音乐名后，可以给
     * 客户端返回这个音乐文件，如果服务器没有这个文件，返回一个默认的音乐即可.
     * (3)客户端收到文件后，保存到本地e:test
     * (4)提示:该程序可以使用StreamUtils.java
     * 本质:其实就是指定下载文件的应用。
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要下载的音乐名（高山流水）:");
        String name = scanner.nextLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(name);
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String fileName = br.readLine();
        String path = "E:\\"+fileName;
        File file = new File(path);
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = bis.read(buf)) != -1) {
            bos.write(buf,0,readLen);
        }
        System.out.println(fileName+"下载成功!");

        bos.close();
        bis.close();
        br.close();
        bw.close();
        socket.close();

    }
}
