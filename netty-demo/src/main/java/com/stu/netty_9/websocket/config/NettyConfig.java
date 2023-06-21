package com.stu.netty_9.websocket.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "netty")
public class NettyConfig {
    /**
     * netty监听的端口
     */
    private int port;
    /**
     * websocket访问路径
     */
    private String path;
}
