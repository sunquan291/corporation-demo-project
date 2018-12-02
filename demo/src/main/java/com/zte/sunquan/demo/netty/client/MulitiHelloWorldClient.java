package com.zte.sunquan.demo.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * Created by 10184538 on 2016/11/11.
 */
public class MulitiHelloWorldClient {
    static class HelloWord implements Runnable {
        final String HOST = System.getProperty("host", "127.0.0.1");
        final int PORT = Integer.parseInt(System.getProperty("port", "8007"));

        public void run() {
            EventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap b = new Bootstrap();
                b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            public void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline p = ch.pipeline();
                                p.addLast(new ObjectEncoder(), new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
                                        new HelloWorldClientHandler());
                            }
                        });

                ChannelFuture f = b.connect(HOST, PORT);

//                f.addListener(new ChannelFutureListener() {
//                    @Override
//                    public void operationComplete(ChannelFuture future) throws Exception {
//                        if (future.isSuccess()) {
//                            System.out.println("bbbbbbbb");
//                            future.channel().write(Unpooled.buffer().writeBytes("123".getBytes()));
//                            future.channel().flush();
//                        }
//                    }
//                });
                f.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                group.shutdownGracefully();
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(new HelloWord()).start();
        }
    }

}
