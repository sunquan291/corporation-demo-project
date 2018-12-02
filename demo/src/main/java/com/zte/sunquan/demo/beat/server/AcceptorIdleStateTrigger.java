package com.zte.sunquan.demo.beat.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Created by 10184538 on 2018/1/15.
 */
@ChannelHandler.Sharable
public class AcceptorIdleStateTrigger extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleState state = ((IdleStateEvent) evt).state();
            if (state == IdleState.READER_IDLE) {
                ctx.fireChannelInactive();//无法通知,无法触发重连
                ctx.disconnect();//能够通知客户端
                System.out.println("READER_IDLE");
//                throw new Exception("idle exception");//能够通知端
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}
