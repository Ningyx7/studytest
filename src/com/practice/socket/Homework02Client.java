package com.practice.socket;

import java.io.IOException;
import java.net.*;

public class Homework02Client {
    /**
     * (1)编写个接收端A,和一个发送端B，使用UDP协议完成
     * (2)接收端在8888端等待接收数据(receive)
     * (3)发送端向接收端发送数据"四大名著是哪些"
     * (4)接收端接收到发送端发送的问题后，返回"四大名著是< <红楼梦>> .." 否则返回what?
     * (5)接收端和发送端程序退出
     * */
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8889);
        String msg="四大名著是哪些";
        byte[] buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 8888);
        socket.send(packet);

        buf=new byte[1024];
        packet=new DatagramPacket(buf,buf.length);
        socket.receive(packet);
        byte[] data = packet.getData();
        int length = packet.getLength();
        System.out.println(new String(data,0,length));


    }
}
