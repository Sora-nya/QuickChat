package com.hyouha.QuickChat.model;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ChatRoom {
    private String id;
    private String token;
    private String admin;
    private List<ChatMessage> messages;
    private Set<String> participants;
}
