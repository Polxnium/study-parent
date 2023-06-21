package com.stu.bio_1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * BIO
 *
 * @Author wangyixing
 * @Description
 */
public class ClientDemo {
    public static void main(String[] args) throws Exception {
        while (true) {
            Socket socket = new Socket("127.0.0.1", 9999);
            socket.setKeepAlive(true);
            socket.setTcpNoDelay(true);
            //从连接中取出输出流，从而发送消息
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("请输入:");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            outputStream.write(message.getBytes());
            //从连接中取出输入流，从而获取消息
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            System.out.println(String.format("Socket收到消息:%s", new String(bytes, 0, read)));
            socket.close();
        }
    }
}
