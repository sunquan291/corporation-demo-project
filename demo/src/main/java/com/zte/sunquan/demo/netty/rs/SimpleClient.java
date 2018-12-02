package com.zte.sunquan.demo.netty.rs;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;

/**
 * Created by 10184538 on 2017/12/25.
 */
public class SimpleClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Bootstrap b = new Bootstrap();
        b.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                    }
                });
        b.connect("localhost", 8090).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                future.await();
                if (future.isSuccess()) {
                    future.channel().write(Unpooled.buffer().writeBytes("123".getBytes()));
                    future.channel().flush();
                }
            }
        });
    }
}
