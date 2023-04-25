package com.practice.socket.udp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiverA {
    /**
     * 1.编写一个接收端 A ，和一个发送端 B
     * 2.接收端 A 在 9999 端口等待接收数据（receive）
     * 3.发送端 B 向接收端 A 发送数据“hello,明天吃火锅~”
     * 4.接收端 A 接收到发送端 B 发送的数据，回复“好的，明天见”，再退出
     * 5.发送端接收回复的数据，再退出
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        System.out.println("9999端口已建立，正在监听...");
        //  当有数据包发送到 本机的9999端口时，就会接收到数据
        //  如果没有数据包发送到 本机的9999端口, 就会阻塞等待.
        datagramSocket.receive(datagramPacket);

        byte[] data = datagramPacket.getData();
        int length = datagramPacket.getLength();

        System.out.println(new String(data,0,length));

        String str="好的，明天见~";
        DatagramPacket datagramPacket2 = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("172.25.209.35"),9998);
        datagramSocket.send(datagramPacket2);
        System.out.println("接收端A退出...");

    }
}
