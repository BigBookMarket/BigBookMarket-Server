package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Comment;
import com.bigbookmarket.domain.PostCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentListResponseDto {

    private Long commentId;
    private String bookCategory;
    private String bookTitle;
    private Long postId;
    private PostCategory postCategory;
    private String postTitle;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    public CommentListResponseDto(Comment entity) {
        this.commentId = entity.getCommentId();
        this.bookCategory = entity.getPost().getBook().getCategory();
        this.bookTitle = entity.getPost().getBook().getTitle();
        this.postId = entity.getPost().getPostId();
        this.postCategory = entity.getPost().getCategory();
        this.postTitle = entity.getPost().getTitle();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
    }
}
