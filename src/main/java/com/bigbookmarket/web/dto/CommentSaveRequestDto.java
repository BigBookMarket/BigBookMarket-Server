package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Comment;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {

    private Long postId;
    private Long userId;
    private String content;

    public Comment toEntity() {
        return Comment.builder()
                .post(Post.builder().postId(postId).build())
                .user(User.builder().userId(userId).build())
                .content(content)
                .build();
    }
}
