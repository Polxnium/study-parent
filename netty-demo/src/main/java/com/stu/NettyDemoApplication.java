package com.stu;

import com.stu.netty_9.websocket.netty.NettyWebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 *
 * @author 86177
 */
@SpringBootApplication(scanBasePackages = {"com.stu.netty_9.websocket"})
public class NettyDemoApplication implements CommandLineRunner {

    @Autowired
    NettyWebSocketServer nettyWebSocketServer;

    public static void main(String[] args) {
        SpringApplication.run(NettyDemoApplication.class, args);
    }

    /**
     * 实现CommandLineRunner接口，以下方法会等IOC容器启动之后执行
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        new Thread(nettyWebSocketServer).start();
    }
}
