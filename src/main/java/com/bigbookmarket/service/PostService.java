package com.bigbookmarket.service;

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
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long Create(PostCreateRequest requestDto) {
        return postRepository.save(requestDto.toEntity()).getPostId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequest requestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("1 해당 사용자가 없습니다. id=" + id));

        post.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("2 해당 사용자가 없습니다. id=" + id));

        postRepository.delete(post);
    }

    @Transactional(readOnly = true)
    public PostResponse read(Long id) {
        Post entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("3 해당 글이 없습니다. id=" + id));

        return new PostResponse(entity);
    }

    @Transactional(readOnly = true)
    public List<PostListResponse> listRead() {
        return postRepository.findAllDesc().stream()
                .map(PostListResponse::new)
                .collect(Collectors.toList());
    }
}