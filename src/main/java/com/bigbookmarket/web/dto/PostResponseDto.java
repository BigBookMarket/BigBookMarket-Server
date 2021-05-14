package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long postId;
    private String nickname;
    private Book book;
    private String title;
    private String content;
    private String modifiedDate;
//    private Integer commentCount; // TODO: 피그마보면 댓글 수가 있기 때문에 여기서 같이 처리 해줘야 함
//    private List<Comment> commenList; // TODO: 해당 글에 대한 댓글 목록도 같이 조회해서 보내줄지? 아니면 프론트에서 API 2번 호출하게 할지?

    public PostResponseDto(Post entity) {
        this.postId = entity.getPostId();
        this.nickname = entity.getUser().getNickname();
        this.book = entity.getBook();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.modifiedDate = entity.getModifiedDate().toString();
    }
}
