package com.hyouha.QuickChat.service;

import com.hyouha.QuickChat.model.ChatMessage;
import com.hyouha.QuickChat.model.ChatRoom;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatService {
    private Map<String, ChatRoom> chatRooms = new HashMap<>();

    public ChatMessage processMessage(ChatMessage chatMessage) {
        ChatRoom room = chatRooms.get(chatMessage.getRoomToken());
        room.getMessages().add(chatMessage);
        chatMessage.setTimestamp(System.currentTimeMillis());
        return chatMessage;
    }

    public ChatMessage addUser(ChatMessage chatMessage) {
        ChatRoom room = chatRooms.get(chatMessage.getRoomToken());
        room.getParticipants().add(chatMessage.getSender());
        return chatMessage;
    }

    public String createRoom() {
        ChatRoom room = new ChatRoom();//todo tworzenie przez konstruktor
        room.setId(UUID.randomUUID().toString());
        room.setToken(UUID.randomUUID().toString());
        room.setAdmin("admin");
        room.setMessages(new ArrayList<>());
        room.setParticipants(new HashSet<>());
        chatRooms.put(room.getToken(), room);
        return room.getToken();
    }

    public ChatRoom getRoom(String roomToken) {
        return chatRooms.get(roomToken);
    }
}
