package com.stu.netty_7.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @Author wangyixing
 * @Description
 */
public class NettyChatClient2 {
    private String ip;
    private int port;
    public NettyChatClient2(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
    public void run() throws InterruptedException {
        EventLoopGroup group = null;
        try {
            group = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new StringEncoder());
                            //自定义handler必须放在编解码器的后面
                            ch.pipeline().addLast(new NettyChatClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(ip, port).sync();
            Channel channel = future.channel();
            String localAddress = channel.localAddress().toString().substring(1);
            System.out.println("===>>> "+localAddress+"启动成功 <<<===");
            //命令行发送消息
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                //向服务端发送消息(聊天室)
                channel.writeAndFlush(scanner.nextLine());
            }
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyChatClient2("127.0.0.1", 8888).run();
    }
}
