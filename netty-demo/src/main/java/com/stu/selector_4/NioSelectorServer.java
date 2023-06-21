package com.stu.selector_4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author wangyixing
 * @Description
 */
public class NioSelectorServer {
    public static void main(String[] args) throws IOException {
        //打开一个服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        //设置成非阻塞的
        serverSocketChannel.configureBlocking(false);
        //打开一个选择器
        Selector selector = Selector.open();
        //将服务端通道注册到选择器上，并指定注册监听的事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动完成...");

        //持续监听客户端连接
        while (true) {
            //select方法检查是否有事件发生，不设置超时会一直阻塞
            int select = selector.select(1000);
            if (select == 0) {
                System.out.println("没有事件发生");
                continue;
            }
            //获取事件集合
            doHandleSelector(serverSocketChannel, selector);
        }
    }

    private static void doHandleSelector(ServerSocketChannel serverSocketChannel,
                                         Selector selector) throws IOException {
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()) {
            SelectionKey selectionKey = iterator.next();
            //判断事件是否是 客户端连接继续事件
            if (selectionKey.isAcceptable()) {
                //获取客户端通道
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("客户端[连接]事件来了");

                //将客户端通道必须设置非阻塞状态，否则selector轮询时会阻塞
                socketChannel.configureBlocking(false);
                //将客户端通道注册到选择器上，并指定注册监听的事件为OP_READ
                socketChannel.register(selector, SelectionKey.OP_READ);
            }
            //判断事件是否是 客户端读就绪事件
            if (selectionKey.isReadable()) {
                //获取客户端通道
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                System.out.println("客户端[读]事件来了");

                //创建一个指定长度的ByteBuffer缓冲区
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int read = socketChannel.read(byteBuffer);
                String data = new String(byteBuffer.array(), 0, read, StandardCharsets.UTF_8);
                System.out.println(String.format("客户端消息=========[%s]", data));

                //向客户端回复消息
                socketChannel.write(ByteBuffer.wrap("服务端收到了".getBytes(StandardCharsets.UTF_8)));
                socketChannel.close();
            }
            //事件处理完从集合中删除，防止二次处理
            iterator.remove();
        }
    }
}
