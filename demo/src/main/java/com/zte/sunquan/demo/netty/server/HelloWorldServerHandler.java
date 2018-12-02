package com.zte.sunquan.demo.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by 10184538 on 2016/11/11.
 */
public class HelloWorldServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Server received msg from client:"+msg);
        System.out.println("Server reply to client with msg:"+(msg+"-Server"));
//        ctx.write((msg+"-Server"));
        ReferenceCountUtil.release(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("Got a client connection");
//        System.out.println("Client:" + ctx.channel().remoteAddress());
//        System.out.println("Server:" + ctx.channel().localAddress());
//        System.out.println("Waiting for client to send msg");
        super.channelActive(ctx);
//        ctx.channel().close().sync();
        System.out.println(ctx.channel()+","+ctx.channel().isActive());
    }
}
