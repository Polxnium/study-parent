package com.stu.netty_6.codec;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @Author wangyixing
 * @Description
 */
public class MessageEncoder extends MessageToMessageEncoder {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
        System.out.println("encoding...");
        String message = (String) o;
        list.add(Unpooled.copiedBuffer(message, CharsetUtil.UTF_8));
    }
}
