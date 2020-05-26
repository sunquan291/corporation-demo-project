package com.zte.sunquan.demo.socket.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * 非阻塞的IO模型，问题是for循环中，需要遍历向所有的client socket问一遍，当1w个连接时
 * 只有一个socket有数据写法，则9999个循环都是性能浪费
 * 关键这个操作会涉及用户态向内核态的切换 考虑能否一次性问多个select
 * select poll epoll
 */
public class SocketNIO {
    public static void main(String[] args) throws Exception {

        LinkedList<SocketChannel> clients = new LinkedList<>();

        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));
        //重点
        ss.configureBlocking(false);

        while (true) {
            Thread.sleep(1000);
            //不会阻塞？
            SocketChannel client = ss.accept();
            if (client == null) {
                System.out.println("null.....");
            } else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("client...port: " + port);
                clients.add(client);
            }
            //可以在堆里   堆外
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            //串行化！！！！  多线程！！
            for (SocketChannel c : clients) {
                // >0  -1  0   //不会阻塞
                int num = c.read(buffer);
                if (num > 0) {
                    buffer.flip();
                    byte[] aaa = new byte[buffer.limit()];
                    buffer.get(aaa);

                    String b = new String(aaa);
                    System.out.println(c.socket().getPort() + " : " + b);
                    buffer.clear();
                }


            }
        }
    }

}
