package com.zjy.udp;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9998);


        byte[] buf = "明天吃火锅".getBytes();

         DatagramPacket datagramPacket =
                new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.253.1"),9999);
        datagramSocket.send(datagramPacket);



        buf = new byte[1024];
        datagramPacket = new DatagramPacket(buf,buf.length);

        datagramSocket.receive(datagramPacket);

        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String string = new String(data, 0, length);
        System.out.println(string);

        datagramSocket.close();


    }
}
