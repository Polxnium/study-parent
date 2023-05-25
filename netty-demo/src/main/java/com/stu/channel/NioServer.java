package com.stu.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * NIO
 *
 * @Author wangyixing
 * @Description
 */
public class NioServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        //打开一个服务端通道，绑定端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9999));
        //通道默认是阻塞的，需要设置成非阻塞
        serverSocketChannel.configureBlocking(false);
        while (true) {
            //服务端会检查是否有客户端连接，有连接就返回客户端通道
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (null == socketChannel) {
                System.out.println("没有客户端连接，我去做别的事");
                Thread.sleep(2000);
                continue;
            }
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //获取客户端传来的数据，并把数据放入ByteBuffer缓冲区
            //read是正数表示读到有效字节数，0没有读到数据，-1读到末尾
            int read = socketChannel.read(byteBuffer);
            System.out.println("客户端消息:"+new String(byteBuffer.array(),0,read,StandardCharsets.UTF_8));

            //给客户端回复数据
            socketChannel.write(ByteBuffer.wrap("你等等我".getBytes()));
            //释放资源
            socketChannel.close();
        }
    }
}
