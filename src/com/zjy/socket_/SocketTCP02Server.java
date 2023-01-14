package com.zjy.socket_;
//服务端


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"all"})
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        //如果没有连接成功9999，那么就会阻塞在这里，不会继续往下执行
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while((readLen = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes , 0 , readLen));
        }
        //socket.shutdownInput();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());
        socket.shutdownOutput();

        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();


    }
}
