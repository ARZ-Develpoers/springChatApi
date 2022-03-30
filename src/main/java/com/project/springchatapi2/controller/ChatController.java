package com.project.springchatapi2.controller;

import com.project.springchatapi2.model.ChatMessage;
import com.project.springchatapi2.repo.ChatRoomRepository;
import com.project.springchatapi2.service.RedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
// import 생략...

@RequiredArgsConstructor
@Controller
public class ChatController {

    //private final SimpMessageSendingOperations messagingTemplate;
    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getType())){
            chatRoomRepository.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }

        redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()),message);
    }
}