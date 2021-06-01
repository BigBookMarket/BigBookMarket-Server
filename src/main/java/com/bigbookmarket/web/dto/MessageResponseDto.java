package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Message;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MessageResponseDto {

    private Long messageId;
    private Long itemId;
    private Book book;
    private String senderId;
    private String senderNickname;
    private String receiverNickname;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    public MessageResponseDto(Message entity) {
        this.messageId = entity.getMessageId();
        this.itemId = entity.getItem().getItemId();
        this.book = entity.getItem().getBook();
        this.senderId = entity.getSender().getId();
        this.senderNickname = entity.getSender().getNickname();
        this.receiverNickname = entity.getReceiver().getNickname();
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
    }
}
