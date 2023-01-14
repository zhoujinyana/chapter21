package com.zjy.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = streamToByteArray(bis);


        String filePath = "src\\qie.PNG";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);
        bos.close();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.flush();
        socket.shutdownOutput();

        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();


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
}
