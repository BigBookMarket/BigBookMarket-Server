package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Comment;
import com.bigbookmarket.domain.Post;
import lombok.Getter;

import java.util.List;

@Getter
public class PostResponseDto {

    private Long postId;
    private String nickname;
    private Book book;
    private String title;
    private String content;
    private String createdDate;
    private Integer commentCount;
    private List<Comment> commentList;

    public PostResponseDto(Post entity) {
        this.postId = entity.getPostId();
        this.nickname = entity.getUser().getNickname();
        this.book = entity.getBook();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate().toString();
        this.commentCount = entity.getComment().size();
        this.commentList = getCommentList();
    }
}
