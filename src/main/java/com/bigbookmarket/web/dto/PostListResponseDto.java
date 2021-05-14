package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Comment;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostCategory;
import lombok.Getter;

import java.util.List;

@Getter
public class PostListResponseDto {

    private Long postId;
    private Book book;
    private String nickname;
    private String title;
    private PostCategory category;
    private String content;
    private Integer commentCount;
    private List<Comment> commentList;
    private String createdDate;

    public PostListResponseDto(Post entity) {
        this.postId = entity.getPostId();
        this.book = entity.getBook();
        this.nickname = entity.getUser().getNickname();
        this.title = entity.getTitle();
        this.category = entity.getCategory();
        this.content = entity.getContent();
        this.commentCount = entity.getComment().size();
        this.createdDate = entity.getCreatedDate().toString();
    }
}
