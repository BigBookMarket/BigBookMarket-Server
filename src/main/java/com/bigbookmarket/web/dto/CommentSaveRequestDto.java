package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Comment;
import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {

    private Long postId;
    private String id;
    private String content;

    public Comment toEntity(User user) {
        return Comment.builder()
                .post(Post.builder().postId(postId).build())
                .user(user)
                .content(content)
                .build();
    }
}
