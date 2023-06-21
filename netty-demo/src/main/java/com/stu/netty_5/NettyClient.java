package com.stu.netty_5;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Author wangyixing
 * @Description Netty客户端
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        //创建客户端线程组
        EventLoopGroup group = new NioEventLoopGroup();
        //创建客户端启动助手
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                //客户端通道NioSocketChannel,原生的是SocketChannel
                .channel(NioSocketChannel.class)
                //向pipeline添加自定义业务处理Handler
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //NettyClientHandler是自定义的业务处理Handler
                        ch.pipeline().addLast(new NettyClientHandler());
                    }
                });
        //启动客户端，连接时将异步改为同步
        ChannelFuture future = bootstrap.connect("127.0.0.1", 8888).sync();
        //关闭通道（并不是真正意义的关闭，而是监听通道的关闭状态）
        future.channel().closeFuture().sync();
        //关闭连接池（上面的sync是指等通道关闭了，才会关闭下面的连接池）
        group.shutdownGracefully();
    }
}
