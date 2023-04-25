package com.practice.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Homework02Server {
    /**
     * (1)编写个接收端A,和一个发送端B，使用UDP协议完成
     * (2)接收端在8888端等待接收数据(receive)
     * (3)发送端向接收端发送数据"四大名著是哪些"
     * (4)接收端接收到发送端发送的问题后，返回"四大名著是<<红楼梦>> .." 否则返回what?
     * (5)接收端和发送端程序退出
     * */
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();

        String mes = new String(data, 0, length);
        String answer = "";

        if("四大名著是哪些".equals(mes)){
            answer="四大名著是<<红楼梦>> ..";
        }else {
            answer="What?";
        }

        buf=answer.getBytes();

        packet=new DatagramPacket(buf,buf.length, InetAddress.getLocalHost(),8889);
        socket.send(packet);

    }
}
