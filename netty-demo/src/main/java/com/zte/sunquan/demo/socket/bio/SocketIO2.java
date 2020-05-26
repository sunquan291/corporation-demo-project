package com.zte.sunquan.demo.socket.bio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketIO2 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9090);
        System.out.println("step1: new ServerSocket(9090) ");
        //阻塞1
        Socket client = server.accept();
        System.out.println("step2:client\t"+client.getPort());
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = client.getInputStream().read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len,"UTF-8"));
        }
        System.out.println("get message from client: " + sb);
        //阻塞2
        while(true){
            System.out.println("hello,world");
        }
    }


}
