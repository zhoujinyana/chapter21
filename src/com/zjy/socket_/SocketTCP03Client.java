package com.zjy.socket_;
//客户端


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings({"all"})
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server,字符流");
        bufferedWriter.newLine();//表示写入类结束
        bufferedWriter.flush();//手动刷新

       // socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
//        byte[] buf = new byte[1024];
//        int readLen = 0;
//        while((readLen = inputStream.read(buf)) != -1){
//            System.out.println(new String(buf,0,readLen));
//        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        bufferedReader.close();
        bufferedWriter.close();
        socket.close();

    }
}
