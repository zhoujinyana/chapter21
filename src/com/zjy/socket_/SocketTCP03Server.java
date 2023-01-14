package com.zjy.socket_;
//服务端


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings({"all"})
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        //如果没有连接成功9999，那么就会阻塞在这里，不会继续往下执行
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //socket.shutdownInput();

        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("hello,client".getBytes());
//        socket.shutdownOutput();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client,字符流");
        bufferedWriter.newLine();//表示写入类结束
        bufferedWriter.flush();//

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();


    }
}
