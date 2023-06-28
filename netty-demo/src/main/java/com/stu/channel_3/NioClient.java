package com.stu.channel_3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Author wangyixing
 * @Description
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        //打开一个客户端通道
        SocketChannel socketChannel = SocketChannel.open();
        //绑定服务器HOST和PORT
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8888));
        //写入数据
        socketChannel.write(ByteBuffer.wrap("今天给我加班".getBytes(StandardCharsets.UTF_8)));
        //创建一个指定长度的ByteBuffer缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //读取服务器写入到通道的数据
        //没有服务端发送的数据可以读取时read()会一直阻塞
        int read = socketChannel.read(byteBuffer);
        String data = new String(byteBuffer.array(), 0, read, StandardCharsets.UTF_8);
        System.out.println(String.format("服务端消息:[%s]",data));
        socketChannel.close();//释放资源
    }
}
