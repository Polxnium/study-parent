package com.stu.channel_3;

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
        serverSocketChannel.bind(new InetSocketAddress(8888));
        //通道设置成非阻塞，默认阻塞
        serverSocketChannel.configureBlocking(false);
        //持续监听客户端连接
        while (true) {
            //检查是否有客户端连接，返回一个通道
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (null == socketChannel) {
                System.out.println("没有客户端连接，服务端在划水");
                Thread.sleep(2000);
                continue;
            }
            //创建一个指定长度的ByteBuffer缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //把客户端的通道数据放入缓冲区，read是正数表示读到有效字节数，0没有读到数据，-1读到末尾
            //没有客户端发送的数据可以读取时read()会一直阻塞
            int read = socketChannel.read(byteBuffer);
            String rec = new String(byteBuffer.array(),0,read,StandardCharsets.UTF_8);
            System.out.println(String.format("客户端消息:[%s]",rec));
            //给客户端回复数据
            ByteBuffer wrap = ByteBuffer.wrap("Server收到了".getBytes(StandardCharsets.UTF_8));
            socketChannel.write(wrap);
            socketChannel.close();//释放资源
        }
    }
}
