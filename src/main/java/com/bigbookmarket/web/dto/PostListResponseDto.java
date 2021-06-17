package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.PostCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
        private Integer commentCount;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdDate;

        public PostList(Map<String, Object> entity) {
            this.postId = Long.parseLong(entity.get("post_id").toString());
            this.category = PostCategory.values()[Integer.parseInt(entity.get("category").toString())];
            this.title = entity.get("title").toString();
            this.nickname = entity.get("nickname").toString();
            this.content = entity.get("content").toString();
            this.commentCount = Integer.parseInt(entity.get("comment_count").toString());
            this.createdDate = LocalDateTime.parse(entity.get("created_date").toString().replace(' ', 'T'));
        }
    }

    public PostListResponseDto(Book entity, List<PostList> postList) {
        this.book = entity;
        this.postList = postList;
    }
}
