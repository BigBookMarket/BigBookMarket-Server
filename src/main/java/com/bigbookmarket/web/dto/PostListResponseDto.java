package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Post;
import com.bigbookmarket.domain.PostCategory;
import lombok.Getter;

@Getter
public class PostListResponseDto {

    private Long postId;
//    private Book book;  // TODO: Book 안에 Post를 포함해서 줄지? 각각 따로 줄지?
    private String nickname;
    private String title;
    private PostCategory category;
    private String content;
//    private Integer commentCount; // TODO: 피그마보면 댓글 수가 있기 때문에 여기서 같이 처리 해줘야 함
    private String modifiedDate;

    public PostListResponseDto(Post entity) {
        this.postId = entity.getPostId();
        this.nickname = entity.getUser().getNickname();
        this.title = entity.getTitle();
        this.category = entity.getCategory();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate().toString();
    }
}
