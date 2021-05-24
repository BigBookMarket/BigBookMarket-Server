package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Item;
import com.bigbookmarket.domain.Message;
import com.bigbookmarket.domain.User;

import lombok.Getter;

@Getter
public class MessageResponseDto {

    private Long messageId;
    private Item item;
    private String sender;
    private String receiver;
    private String content;

    public MessageResponseDto(Message entity) {
        this.messageId = entity.getMessageId();
        this.item = entity.getItem();
        this.sender = entity.getSender().getNickname();
        this.receiver = entity.getReceiver().getNickname();
        this.content = entity.getContent();
    }
}
