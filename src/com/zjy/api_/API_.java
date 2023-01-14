package com.zjy.api_;


import java.net.InetAddress;
import java.net.UnknownHostException;

//演示InetAddress类
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress对象
        InetAddress inetAddress =  InetAddress.getLocalHost();
        System.out.println(inetAddress);

        //根据指定主机名，获取Inet对象
        InetAddress byName = InetAddress.getByName("LAPTOP-STNJUIAM");
        System.out.println(byName);

        //根据域名返回Inet对象
        InetAddress byName1 = InetAddress.getByName("www.baidu.com");
        System.out.println(byName1);

        //通过Inet对象，获取对应的IP地址
        String hostAddress = byName1.getHostAddress();
        System.out.println(hostAddress);

        //通过Inet对象，获取对应的主机名或域名
        String hostName = byName1.getHostName();
        System.out.println(hostName);



    }
}
