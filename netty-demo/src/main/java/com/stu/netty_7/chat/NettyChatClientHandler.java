package com.stu.netty_7.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author wangyixing
 * @Description
 */
public class NettyChatClientHandler extends SimpleChannelInboundHandler<String> {
    /**
     * 通道读取就绪事件
     * @param channelHandlerContext
     * @param s
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        //可以读取服务端发送来的消息
        System.out.println(s);
    }
}
