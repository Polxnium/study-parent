package com.stu.netty_8.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangyixing
 * @Description 消息入站handler
 */
public class NettyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 通道读取事件（通道读事件）
     * @param ctx
     * @param httpObject
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        if (httpObject instanceof HttpRequest) {
            DefaultHttpRequest request = (DefaultHttpRequest) httpObject;
            System.out.println("浏览器请求路径:" + request.uri());
            if (request.uri().equals("/favicon.ico")) {
                System.out.println("不响应/favicon.ico");
                return;
            }
            //给浏览器返回响应信息
            ByteBuf byteBuf = Unpooled.copiedBuffer("服务器收到了", CharsetUtil.UTF_8);
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,
                    byteBuf
            );
            //设置响应头
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=utf-8");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());
            //写入HTTP响应
            ctx.writeAndFlush(response);
        }
    }
}
