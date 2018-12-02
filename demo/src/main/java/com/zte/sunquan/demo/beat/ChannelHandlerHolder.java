package com.zte.sunquan.demo.beat;

import io.netty.channel.ChannelHandler;

/**
 * Created by 10184538 on 2018/1/15.
 */
public interface ChannelHandlerHolder {
    ChannelHandler[] handlers();
}
