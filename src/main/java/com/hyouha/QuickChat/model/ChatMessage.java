package com.hyouha.QuickChat.model;

import lombok.Data;

@Data
public class ChatMessage {
    private String content;
    private String sender;
    private long timestamp;
    private String roomToken;
}

