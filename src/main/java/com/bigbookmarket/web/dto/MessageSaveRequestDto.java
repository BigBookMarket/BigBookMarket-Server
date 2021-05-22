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

    public Message toEntity() {
        return Message.builder()
                .item(Item.builder().itemId(itemId).build())
                .sender(User.builder().id(senderId).build())
                .receiver(User.builder().id(receiverId).build())
                .content(content)
                .build();
    }
}
