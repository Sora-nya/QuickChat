package com.hyouha.QuickChat.controller;

import com.hyouha.QuickChat.model.ChatMessage;
import com.hyouha.QuickChat.model.ChatRoom;
import com.hyouha.QuickChat.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatService.processMessage(chatMessage);
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage chatMessage) {
        return chatService.addUser(chatMessage);
    }

    @PostMapping("/chat/room/create")
    public String createRoom() {
        return chatService.createRoom();
    }

    @GetMapping("/chat/room/{roomToken}")
    public ChatRoom getRoom(@PathVariable String roomToken) {
        return chatService.getRoom(roomToken);
    }

    @GetMapping("/chat/test")
    public String getTesting() {
        return "test sucessful";
    }
}
