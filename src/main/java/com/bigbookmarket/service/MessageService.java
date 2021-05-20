package com.bigbookmarket.service;

import com.bigbookmarket.domain.MessageRepository;
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

//    @Transactional(readOnly = true)
//    public List<PostCommentHistoryListResponseDto> findByUserIdComment(Long userId) {
//        return postRepository.findByUserIdComment(userId).stream()
//                .map(PostCommentHistoryListResponseDto::new)
//                .collect(Collectors.toList());
//    }
//}
}