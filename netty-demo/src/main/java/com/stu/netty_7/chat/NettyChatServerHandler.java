package com.stu.netty_7.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangyixing
 * @Description 消息入站handler，继承SimpleChannelInboundHandler用来代替ChannelInboundHandler，因为实现ChannelInboundHandler时需要重写全部方法
 */
public class NettyChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static List<Channel> channelList = new ArrayList<>();

    /**
     * 通道就绪事件（通道上线/连接）
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //当有新的客户端连接时，将通道放入集合
        Channel channel = ctx.channel();
        channelList.add(channel);
        String remoteAddress = channel.remoteAddress().toString().substring(1);
        System.out.println("[Server]:"+remoteAddress+"上线了");
    }

    /**
     * 通道读取事件（通道读事件）
     * @param ctx
     * @param s
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        //当前发送消息的通道，当前发送的客户端连接
        Channel channelSelf = ctx.channel();
        for (Channel channel : channelList) {
            //排除自身，不发送给自己
            if (channel == channelSelf) {
                continue;
            }
            //发送消息给其它所有人
            String remoteAddress = channelSelf.remoteAddress().toString().substring(1);
            channel.writeAndFlush("["+remoteAddress+"]说:"+s);
        }
    }

    /**
     * 通道未就绪（通道下线）
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //当有客户端断开链接的时候，就移除对应的通道
        Channel channel = ctx.channel();
        channelList.remove(channel);
        String remoteAddress = channel.remoteAddress().toString().substring(1);
        System.out.println("[Server]:"+remoteAddress+"下线了");
    }

    /**
     * 异常处理事件
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        Channel channel = ctx.channel();
        channelList.remove(channel);
        String remoteAddress = channel.remoteAddress().toString().substring(1);
        System.out.println("[Server]:"+remoteAddress+"异常了");
    }

}
