package com.stu;

import com.stu.netty_9.websocket.netty.NettyWebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * SpringBoot有两种方式在启动时设置初始化数据，执行时机都是在ApplicationContext完全初始化之后
 * 1.实现ApplicationRunner接口的run()方法
 * 2.实现CommandLineRunner接口的run()方法
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
     * IOC容器完全初始化后，再启动WebSocket监听
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        new Thread(nettyWebSocketServer).start();
    }
}
