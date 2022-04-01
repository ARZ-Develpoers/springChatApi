package com.project.springchatapi2.controller;

import com.project.springchatapi2.config.JwtTokenProvider;
import com.project.springchatapi2.model.ChatMessage;
import com.project.springchatapi2.repo.ChatRoomRepository;
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

    @MessageMapping("/chat/message")
    public void message(ChatMessage message, @Header("token") String token) {
        log.info("토큰맨"+token);

        String nickName = jwtTokenProvider.getUserNameFroJwt(token);
        message.setSender(nickName);

        if (ChatMessage.MessageType.ENTER.equals(message.getType())){
            //chatRoomRepository.enterChatRoom(message.getRoomId());
            message.setSender("[알림]");
            message.setMessage(nickName + "님이 입장하셨습니다.");
        }

        //redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()),message);
        redisTemplate.convertAndSend(channelTopic.getTopic(), message);
    }
}