package com.bigbookmarket.service;

import com.bigbookmarket.domain.*;
import com.bigbookmarket.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(MessageSaveRequestDto requestDto) {
        Item itemId = itemRepository.findById(requestDto.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemid=" + requestDto.getItemId()));
        User senderId = userRepository.findById(requestDto.getSenderId())
                .orElseThrow(() -> new IllegalArgumentException("해당 Sender가 없습니다. senderid=" + requestDto.getSenderId()));
        User receiverId = userRepository.findById(requestDto.getSenderId())
                .orElseThrow(() -> new IllegalArgumentException("해당 Receiver가 없습니다. receiverid=" + requestDto.getReceiverId()));
        return messageRepository.save(requestDto.toEntity(itemId, senderId, receiverId)).getMessageId();
    }

    @Transactional(readOnly = true)
    public MessageResponseDto findByMessageId(Long messageId) {
        Message entity = messageRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Message가 없습니다. messageId=" + messageId));
        return new MessageResponseDto(entity);
    }
}