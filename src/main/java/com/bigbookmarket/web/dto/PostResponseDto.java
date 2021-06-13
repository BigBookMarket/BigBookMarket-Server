package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Comment;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostResponseDto {

    private Long postId;
    private String nickname;
    private Book book;
    private String title;
    private PostCategory category;
    private String content;
    private Integer commentCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    private List<CommentList> commentList;

    @Getter
    public class CommentList {
        private Long commentId;
        private String nickname;
        private String content;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdDate;

        public CommentList(Comment entity) {
            this.commentId = entity.getCommentId();
            this.nickname = entity.getUser().getNickname();
            this.content = entity.getContent();
            this.createdDate = entity.getCreatedDate();
        }
    }

    public PostResponseDto(Post entity, List<CommentList> commentList) {
        this.postId = entity.getPostId();
        this.nickname = entity.getUser().getNickname();
        this.book = entity.getBook();
        this.title = entity.getTitle();
        this.category = entity.getCategory();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
        this.commentCount = commentList.size();
        this.commentList = commentList;
    }
}
