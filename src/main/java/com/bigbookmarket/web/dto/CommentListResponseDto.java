package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Comment;
import com.bigbookmarket.domain.Post;

import lombok.Getter;

@Getter
public class CommentListResponseDto {

    private Long commentId;
    //private Post post;
    private Long userId;
    private String content;

    public CommentListResponseDto(Comment entity) {
        this.commentId = entity.getCommentId();
        //this.post = entity.getPost();
        this.userId = entity.getUser().getUserId();
        this.content = entity.getContent();
    }
}
