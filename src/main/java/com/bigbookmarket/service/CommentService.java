package com.bigbookmarket.service;

import com.bigbookmarket.domain.Comment;
import com.bigbookmarket.domain.CommentRepository;
import com.bigbookmarket.domain.User;
import com.bigbookmarket.domain.UserRepository;
import com.bigbookmarket.web.dto.CommentSaveRequestDto;
import com.bigbookmarket.web.dto.CommentUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Long update(Long commentId, CommentUpdateRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException(("해당 Comment가 없습니다. commentId = " + commentId)));
        comment.update(requestDto.getContent());
        return commentId;
    }

    @Transactional
    public Long delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException(("해당 Comment가 없습니다. commentId = " + commentId)));
        commentRepository.delete(comment);
        return commentId;
    }
}
