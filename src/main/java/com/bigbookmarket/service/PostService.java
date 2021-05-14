package com.bigbookmarket.service;

import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostRepository;
import com.bigbookmarket.web.dto.PostListResponseDto;
import com.bigbookmarket.web.dto.PostResponseDto;
import com.bigbookmarket.web.dto.PostSaveRequestDto;
import com.bigbookmarket.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<PostListResponseDto> findAllDesc() {
        return postRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findByBookId(String bookId) {
        return postRepository.findByBookId(bookId).stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }
}