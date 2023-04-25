package com.practice.socket.udp;

import java.io.IOException;
import java.net.*;

public class UDPSenderB {
    /**
     *  1.编写一个接收端 A ，和一个发送端 B
     *  2.接收端 A 在 9999 端口等待接收数据（receive）
     *  3.发送端 B 向接收端 A 发送数据“hello,明天吃火锅~”
     *  4.接收端 A 接收到发送端 B 发送的数据，回复“好的，明天见”，再退出
     *  5.发送端接收回复的数据，再退出
     * */
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        String str = "hello,明天吃火锅~";
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("172.25.209.35"), 9999);
        datagramSocket.send(datagramPacket);
        System.out.println("发送信息完成");

        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket2 = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(datagramPacket2);
        byte[] data = datagramPacket2.getData();
        int length = datagramPacket2.getLength();
        System.out.println(new String(data,0,length));

    }
}
