package com.zjy.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        String filePath = "e:\\qie.PNG";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        byte[] bytes = streamToByteArray(bis);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bis.close();
        socket.shutdownOutput();


        InputStream inputStream = socket.getInputStream();
        String s = streamToString(inputStream);
        System.out.println(s);

        inputStream.close();
        bos.close();
        socket.close();


    }

    public static  byte[] streamToByteArray(InputStream is) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建输出流对象
        byte[] b = new byte[1024];//字节数组
        int len;
        while ((len = is.read(b)) != -1) {//循环读取
            bos.write(b, 0, len);//把读取到的数据,写入bos
        }
        byte[] array = bos.toByteArray();//然后将bos 转成字节数组
        bos.close();
        return array;

    }
    public static String streamToString(InputStream is) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder= new StringBuilder();
        String line;
        while((line=reader.readLine())!=null){
            builder.append(line+"\r\n");
        }
        return builder.toString();

    }
}
