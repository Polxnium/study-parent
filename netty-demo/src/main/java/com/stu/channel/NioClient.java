package com.stu.channel;

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
        //连接服务器IP和端口
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
        //写入数据
        socketChannel.write(ByteBuffer.wrap("我要回家了".getBytes(StandardCharsets.UTF_8)));

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //读取服务器返回的数据
        int read = socketChannel.read(byteBuffer);
        System.out.println("服务端消息:"+new String(byteBuffer.array(),0,read,StandardCharsets.UTF_8));
        //释放资源
        socketChannel.close();
    }
}
