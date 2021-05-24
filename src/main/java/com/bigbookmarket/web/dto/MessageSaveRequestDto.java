package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Item;
import com.bigbookmarket.domain.Message;
import com.bigbookmarket.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageSaveRequestDto {

    private Long itemId;
    private String senderId;
    private String receiverId;
    private String content;

    public Message toEntity(Item item, User sender, User receiver) {
        return Message.builder()
                .item(item)
                .sender(sender)
                .receiver(receiver)
                .content(content)
                .build();
    }
}
