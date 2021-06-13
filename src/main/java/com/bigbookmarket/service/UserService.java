package com.bigbookmarket.service;

import com.bigbookmarket.domain.*;
import com.bigbookmarket.web.dto.CommentListResponseDto;
import com.bigbookmarket.web.dto.ItemListResponseDto;
import com.bigbookmarket.web.dto.MessageResponseDto;
import com.bigbookmarket.web.dto.UserPostListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final ItemRepository itemRepository;
    private final MessageRepository messageRepository;

    @Transactional(readOnly = true)
    public List<ItemListResponseDto> findBySellerId(String id) {
        Long sellerId = userRepository.findById(id).get().getUserId(); // TODO: 에러처리
        return itemRepository.findBySellerId(sellerId).stream()
                .map(ItemListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ItemListResponseDto> findByBuyerId(String id) {
        Long buyerId = userRepository.findById(id).get().getUserId(); // TODO: 에러처리
        return itemRepository.findByBuyerId(buyerId).stream()
                .map(ItemListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MessageResponseDto> findByInboxId(String id) {
        Long inboxId = userRepository.findById(id).get().getUserId(); // TODO: 에러처리
        return messageRepository.findByInboxId(inboxId).stream()
                .map(MessageResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MessageResponseDto> findByOutboxId(String id) {
        Long outboxId = userRepository.findById(id).get().getUserId(); // TODO: 에러처리
        return messageRepository.findByOutboxId(outboxId).stream()
                .map(MessageResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<UserPostListResponseDto> findPostById(String id) {
        Long userId = userRepository.findById(id).get().getUserId(); // TODO: 에러처리
        return postRepository.findByUser_userIdOrderByCreatedDateDesc(userId).stream()
                .map(UserPostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CommentListResponseDto> findCommentById(String id) {
        Long userId = userRepository.findById(id).get().getUserId(); // TODO: 에러처리
        return commentRepository.findByUser_userIdOrderByCreatedDateDesc(userId).stream()
                .map(CommentListResponseDto::new)
                .collect(Collectors.toList());
    }
}
