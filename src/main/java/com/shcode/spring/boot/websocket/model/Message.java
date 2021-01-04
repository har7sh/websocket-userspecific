package com.shcode.spring.boot.websocket.model;

import lombok.Data;

@Data
public class Message {

    private String content;

    private String sender;

    private MessageType type;

    public enum MessageType {
        CHAT, LEAVE, JOIN;
    }
}
