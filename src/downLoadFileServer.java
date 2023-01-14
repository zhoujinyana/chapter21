
import jdk.management.resource.internal.inst.SocketInputStreamRMHooks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class downLoadFileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        String fileName = "";
        while((len = inputStream.read())!=-1){
            fileName += new String(buf,0,len);
        }
        System.out.println("客户希望下载的文件" + fileName);


        String resName = "";
        if("高山流水".equals(fileName)){
            resName = "src\\高三流水.mp3";
        }else{
            resName = "src\\qie.PNG";
        }

        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream(resName));


        //byte[] bytes = streamUtils.streamToByteArray(bis);//6．得到Socket关联的输出流
        BufferedOutputStream bos =
                new BufferedOutputStream(socket.getOutputStream());
        //7．写入到数据通道，返回给客户端
        //bos.write(bytes);
        socket.shutdownOutput();
        //8 关闭相关的资源
        //bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出.. ");


    }
}
