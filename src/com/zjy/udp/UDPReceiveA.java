package com.zjy.udp;

import java.io.IOException;
import java.net.*;

public class UDPReceiveA {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);

        datagramSocket.receive(datagramPacket);

        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String string = new String(data, 0, length);
        System.out.println(string);


        buf = "好的，明天见".getBytes();

        datagramPacket =
                new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.253.1"),9998);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();



    }
}
