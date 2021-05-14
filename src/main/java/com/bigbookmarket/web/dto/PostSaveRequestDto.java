package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostCategory;
import com.bigbookmarket.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private Long userId;
    private String bookId;
    private PostCategory category;
    private String title;
    private String content;

    public Post toEntity() {
        return Post.builder()
                .user(User.builder().userId(userId).build())
                .book(Book.builder().bookId(bookId).build())
                .category(category)
                .title(title)
                .content(content)
                .build();
    }
}
