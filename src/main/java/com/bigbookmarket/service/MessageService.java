package com.bigbookmarket.service;

import com.bigbookmarket.domain.Message;
import com.bigbookmarket.domain.MessageRepository;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostRepository;
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

    @Transactional
    public Long save(MessageSaveRequestDto requestDto) {
        return messageRepository.save(requestDto.toEntity()).getMessageId();
    }

    @Transactional(readOnly = true)
    public MessageResponseDto findByMessageId(Long messageId) {
        Message entity = messageRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Message가 없습니다. messageId=" + messageId));
        return new MessageResponseDto(entity);
    }
}