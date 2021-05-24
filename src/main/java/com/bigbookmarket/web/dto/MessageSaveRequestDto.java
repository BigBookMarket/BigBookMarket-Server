package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageSaveRequestDto {

    private Long itemId;
    private String senderId;
    private String receiverId;
    private String content;

    public Message toEntity(Item itemId, User sender, User receiver) {
        return Message.builder()
                .item(itemId)
                .sender(sender)
                .receiver(receiver)
                .content(content)
                .build();
    }
}
