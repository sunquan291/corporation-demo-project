package com.zte.sunquan.demo.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by 10184538 on 2016/11/11.
 */
public class HelloWorldClientHandler extends ChannelInboundHandlerAdapter {
    private final String msg = "hello java world";


    /**
     * Creates a client-side handler.
     */
    public HelloWorldClientHandler() {
        //TODO
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        //客户端获取连接后，即发送消息hello java world
        ctx.writeAndFlush(msg);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        System.out.println("inactive");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Client received msg from server:"+msg);
        //ctx.write(msg);
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("aaaaaaaaaa");
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
