package com.bigbookmarket.service;

import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostRepository;
import com.bigbookmarket.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getPostId();
    }

    @Transactional
    public Long update(Long postId, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Post가 없습니다. postId=" + postId));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return postId;
    }

    @Transactional
    public void delete(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Post가 없습니다. postId=" + postId));
        postRepository.delete(post);
    }

    @Transactional(readOnly = true)
    public PostResponseDto findById(Long postId) {
        Post entity = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Post가 없습니다. postId=" + postId));
        return new PostResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostHistoryListResponseDto> findByUserId(Long userId) {
        return postRepository.findByUserId(userId).stream()
                .map(PostHistoryListResponseDto::new)
                .collect(Collectors.toList());
    }

//    @Transactional(readOnly = true)
//    public PostListResponseDto findByBookId(String bookId) {
//        List<Post> entity = new ArrayList<>(postRepository.findByBookId(bookId));
//        return new PostListResponseDto(entity);
//    }
}