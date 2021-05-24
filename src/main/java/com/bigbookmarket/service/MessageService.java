package com.bigbookmarket.service;

import com.bigbookmarket.domain.*;
import com.bigbookmarket.web.dto.MessageResponseDto;
import com.bigbookmarket.web.dto.MessageSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(MessageSaveRequestDto requestDto) {
        Item item = itemRepository.findById(requestDto.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId=" + requestDto.getItemId()));
        User sender = userRepository.findById(requestDto.getSenderId())
                .orElseThrow(() -> new IllegalArgumentException("해당 Sender가 없습니다. senderId=" + requestDto.getSenderId()));
        User receiver = userRepository.findById(requestDto.getReceiverId())
                .orElseThrow(() -> new IllegalArgumentException("해당 Receiver가 없습니다. receiverId=" + requestDto.getReceiverId()));
        return messageRepository.save(requestDto.toEntity(item, sender, receiver)).getMessageId();
    }

    @Transactional(readOnly = true)
    public MessageResponseDto findByMessageId(Long messageId) {
        Message entity = messageRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Message가 없습니다. messageId=" + messageId));
        return new MessageResponseDto(entity);
    }
}