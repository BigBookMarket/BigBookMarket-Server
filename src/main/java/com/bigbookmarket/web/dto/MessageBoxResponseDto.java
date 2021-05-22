package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Message;

import lombok.Getter;

@Getter
public class MessageBoxResponseDto {

    private String category;
    private String title;
    private String author;
    private String publisher;
    private String pubDate;
    private String userId;
    private String content;

    public MessageBoxResponseDto(Message entity) {
        this.category = entity.getItem().getBook().getCategory();
        this.title = entity.getItem().getBook().getTitle();
        this.author = entity.getItem().getBook().getAuthor();
        this.publisher = entity.getItem().getBook().getPublisher();
        this.pubDate = entity.getItem().getBook().getPubDate();
        this.userId = entity.getSender().getNickname();
        this.content = entity.getContent();
    }
}
