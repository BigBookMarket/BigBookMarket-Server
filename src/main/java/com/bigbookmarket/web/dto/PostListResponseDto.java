package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class PostListResponseDto {

    private Book book;
    private List<PostList> postList;

    @Getter
    public class PostList {
        private Long postId;
        private PostCategory category;
        private String title;
        private String nickname;
        private String content;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdDate;

        public PostList(Post entity) {
            this.postId = entity.getPostId();
            this.category = entity.getCategory();
            this.title = entity.getTitle();
            this.nickname = entity.getUser().getNickname();
            this.content = entity.getContent();
            this.createdDate = entity.getCreatedDate();
        }
    }

    public PostListResponseDto(Book entity, List<PostList> postList) {
        this.book = entity;
        this.postList = postList;
    }
}
