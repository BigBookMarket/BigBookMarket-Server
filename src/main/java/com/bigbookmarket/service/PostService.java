package com.bigbookmarket.service;

import com.bigbookmarket.domain.*;
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

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 User가 없습니다. id = " + requestDto.getId()));
        return postRepository.save(requestDto.toEntity(user)).getPostId();
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
        List<PostResponseDto.CommentList> commentList = commentRepository.findByPost_PostIdOrderByCreatedDateDesc(postId).stream()
                .map(comment -> new PostResponseDto().new CommentList(comment))
                .collect(Collectors.toList());
        return new PostResponseDto(entity, commentList);
    }

    @Transactional(readOnly = true)
    public PostListResponseDto findByBookId(String bookId) {
        Book entity = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Book이 없습니다. bookId=" + bookId));
        List<PostListResponseDto.PostList> postList = postRepository.findByBook_BookIdOrderByCreatedDateDesc(bookId).stream()
                .map(post -> new PostListResponseDto().new PostList(post))
                .collect(Collectors.toList());
        return new PostListResponseDto(entity, postList);
    }
}