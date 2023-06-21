package com.stu.netty_5;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author wangyixing
 * @Description Netty服务端 - 主从Reactor线程模型
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        //创建bossGroup线程组，用于处理网络连接事件
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //创建workerGroup线程组，用于处理网络读/写事件，默认2倍的处理器线程数
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //创建服务端启动助手
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //绑定两个线程组
        serverBootstrap.group(bossGroup, workerGroup)
                //服务端通道为NioServerSocketChannel,原生的是ServerSocketChannel
                .channel(NioServerSocketChannel.class)
                //bossGroup的参数设置，等待连接的队列128
                .option(ChannelOption.SO_BACKLOG, 128)
                //workerGroup的参数设置，通道活跃的状态
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                //向workerGroup的pipeline添加自定义业务处理Handler
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //NettyServerHandler是自定义的业务处理Handler
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                });
        //启动服务端并绑定端口，绑定时将异步改为同步（端口绑定成功才能提供服务）
//        ChannelFuture future = serverBootstrap.bind(8888).sync();
//        System.out.println("===>>> NettyServer started <<<===");
        ChannelFuture future = serverBootstrap.bind(8888);
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    System.out.println("端口绑定成功");
                } else {
                    System.out.println("端口绑定失败");
                }
            }
        });
        System.out.println("===>>> NettyServer started <<<===");
        //关闭通道（并不是真正意义的关闭，而是监听通道的关闭状态）
        future.channel().closeFuture().sync();
        //关闭连接池（上面的sync是指等通道关闭了，才会关闭下面的连接池）
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}
