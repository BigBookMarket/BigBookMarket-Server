package com.bigbookmarket.service;
import com.bigbookmarket.domain.CommentRepository;
import com.bigbookmarket.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long save(CommentSaveRequestDto requestDto) {
        return commentRepository.save(requestDto.toEntity()).getCommentId();
    }

    @Transactional(readOnly = true)
    public List<CommentListResponseDto> findBYPostIdComment(Long postId) {
        return commentRepository.findBYPostIdComment(postId).stream()
                .map(CommentListResponseDto::new)
                .collect(Collectors.toList());
    }
}
