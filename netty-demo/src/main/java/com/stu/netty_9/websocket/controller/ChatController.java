package com.stu.netty_9.websocket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 86177
 */
@Controller
public class ChatController {

    @RequestMapping("/")
    public String chat() {
        return "chat";
    }
}