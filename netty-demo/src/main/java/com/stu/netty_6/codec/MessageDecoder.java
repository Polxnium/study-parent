package com.stu.netty_6.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * @Author wangyixing
 * @Description 消息解码器
 */
public class MessageDecoder extends MessageToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Object o, List list) throws Exception {
        System.out.println("decoding...");
        //传递到下一个handler
        ByteBuf byteBuf = (ByteBuf) o;
        list.add(byteBuf.toString(CharsetUtil.UTF_8));
    }
}
