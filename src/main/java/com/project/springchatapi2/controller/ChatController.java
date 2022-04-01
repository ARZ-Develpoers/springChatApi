package com.project.springchatapi2.controller;

import com.project.springchatapi2.config.JwtTokenProvider;
import com.project.springchatapi2.model.ChatMessage;
import com.project.springchatapi2.repo.ChatRoomRepository;
import com.project.springchatapi2.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
// import 생략...

@Slf4j
@RequiredArgsConstructor
@Controller
public class ChatController {

    //private final SimpMessageSendingOperations messagingTemplate;
    //private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTemplate redisTemplate;
    private final ChannelTopic channelTopic;

    private final ChatService chatService;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message, @Header("token") String token) {

        String nickName = jwtTokenProvider.getUserNameFroJwt(token);
        message.setSender(nickName);

        message.setUserCount(chatRoomRepository.getUserCount(message.getRoomId()));
        chatService.sendChatMessage(message);
    }
}