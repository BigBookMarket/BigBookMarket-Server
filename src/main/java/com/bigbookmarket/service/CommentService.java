package com.bigbookmarket.service;

import com.bigbookmarket.domain.CommentRepository;
import com.bigbookmarket.domain.User;
import com.bigbookmarket.domain.UserRepository;
import com.bigbookmarket.web.dto.CommentListResponseDto;
import com.bigbookmarket.web.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long save(CommentSaveRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 User가 없습니다. id = " + requestDto.getId()));
        return commentRepository.save(requestDto.toEntity(user)).getCommentId();
    }

    @Transactional(readOnly = true)
    public List<CommentListResponseDto> findBYPostIdComment(Long postId) {
        return commentRepository.findBYPostIdComment(postId).stream()
                .map(CommentListResponseDto::new)
                .collect(Collectors.toList());
    }
}
