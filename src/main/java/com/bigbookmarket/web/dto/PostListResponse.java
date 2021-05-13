package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostListResponse {

    private Long postId;
    private User user;
    private Book book;
    private Byte category;
    private String title;
    private String content;
    private final LocalDateTime modifiedDate;

    public PostListResponse(Post entity) {
        this.postId = entity.getPostId();
        this.user = entity.getUser();
        this.book = entity.getBook();
        this.category = entity.getCategory();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate();
    }
}
