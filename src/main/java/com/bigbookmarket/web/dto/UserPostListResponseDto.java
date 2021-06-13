package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserPostListResponseDto {

    private Long postId;
    private Book book;
    private String nickname;
    private String title;
    private PostCategory category;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    public UserPostListResponseDto(Post entity) {
        this.postId = entity.getPostId();
        this.book = entity.getBook();
        this.nickname = entity.getUser().getNickname();
        this.title = entity.getTitle();
        this.category = entity.getCategory();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
    }
}
