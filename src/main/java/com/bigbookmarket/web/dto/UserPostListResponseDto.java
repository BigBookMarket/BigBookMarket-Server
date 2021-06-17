package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@NoArgsConstructor
public class UserPostListResponseDto {

    private Long postId;
    private Book book;
    private String title;
    private PostCategory category;
    private String content;
    private Integer commentCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    public UserPostListResponseDto(Map<String, Object> entity) {
        this.postId = Long.parseLong(entity.get("post_id").toString());
        this.book = Book.builder()
                .bookId(entity.get("book_id").toString())
                .title(entity.get("title").toString())
                .author(entity.get("author").toString())
                .category(entity.get("category").toString())
                .publisher(entity.get("publisher").toString())
                .pubDate(entity.get("pub_date").toString())
                .priceStandard(Integer.parseInt(entity.get("price_standard").toString()))
                .image(entity.get("image").toString())
                .build();
        this.title = entity.get("post_title").toString();
        this.category = PostCategory.values()[Integer.parseInt(entity.get("post_category").toString())];
        this.content = entity.get("content").toString();
        this.commentCount = Integer.parseInt(entity.get("comment_count").toString());
        this.createdDate = LocalDateTime.parse(entity.get("created_date").toString().replace(' ', 'T'));
    }
}
