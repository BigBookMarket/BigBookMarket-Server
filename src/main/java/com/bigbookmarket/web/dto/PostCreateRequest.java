package com.bigbookmarket.web.dto;


import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateRequest {
    private User user;
    private Book book;
    private Byte category;
    private String title;
    private String content;

    @Builder
    public PostCreateRequest(User user, Book book, Byte category, String title, String content) {
        this.user = user;
        this.book = book;
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public Post toEntity() {
        return Post.builder()
                .user(user)
                .book(book)
                .category(category)
                .title(title)
                .content(content)
                .build();
    }
}
