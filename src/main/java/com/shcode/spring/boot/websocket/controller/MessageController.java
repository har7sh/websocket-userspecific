package com.shcode.spring.boot.websocket.controller;

import com.shcode.spring.boot.websocket.model.Message;
import com.shcode.spring.boot.websocket.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/message.register")
    public void register(@Payload Message message) throws Exception {
        messageService.addUserName(message.getSender());
        Thread.sleep(1000);
    }

    @MessageMapping("/message.send")
    public void sendMessage(@Payload String message) {
        messageService.sendMessages(message);
    }
}
