package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Item;
import com.bigbookmarket.domain.Message;
import com.bigbookmarket.domain.User;

import lombok.Getter;

@Getter
public class MessageResponseDto {

    private Long messageId;
    private Item item;
    private User sender;
    private User receiver;
    private String content;

    public MessageResponseDto(Message entity) {
        this.messageId = entity.getMessageId();
        this.item = entity.getItem();
        this.sender = entity.getSender();
        this.receiver = entity.getReceiver();
        this.content = entity.getContent();
    }
}
