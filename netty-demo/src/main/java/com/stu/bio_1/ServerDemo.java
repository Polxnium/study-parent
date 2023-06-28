package com.stu.bio_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * BIO
 *
 * @Author wangyixing
 * @Description
 */
public class ServerDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = new ThreadPoolExecutor(8, 16, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            //ServerSocket监听客户端Socket, 没有客户端连接时会一直阻塞
            Socket socket = serverSocket.accept();
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    doHandlerSocket(socket);
                }
            });
        }
    }

    private static void doHandlerSocket(Socket socket) {
        try {
            long id = Thread.currentThread().getId();
            String name = Thread.currentThread().getName();
            System.out.println(String.format("线程id:%d, name:%s", id, name));
            //从连接中取出输入流，从而获取信息
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            //连接后没有客户端发送的数据可以读取时read()会一直阻塞
            int read = inputStream.read(bytes);
            System.out.println(String.format("客户端数据:%s", new String(bytes, 0, read)));
            //从连接中取出输出流，从而发送消息
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("服务端收到了".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
