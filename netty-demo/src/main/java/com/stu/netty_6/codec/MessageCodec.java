package com.stu.netty_6.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @Author wangyixing
 * @Description 消息编解码器
 */
public class MessageCodec extends MessageToMessageCodec {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
        System.out.println("encoding...");
        String message = (String) o;
        list.add(Unpooled.copiedBuffer(message, CharsetUtil.UTF_8));
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
        System.out.println("decoding...");
        ByteBuf byteBuf = (ByteBuf) o;
        list.add(byteBuf.toString(CharsetUtil.UTF_8));
    }
}
