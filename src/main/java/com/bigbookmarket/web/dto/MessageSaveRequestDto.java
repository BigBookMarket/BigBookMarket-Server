package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageSaveRequestDto {

    private Long messageId;
    private User sender;
    private User receiver;
    private String content;

    public Message toEntity() {
        return Message.builder()
                .messageId(messageId)
                .sender(User.builder().userId(sender.getUserId()).build())
                .receiver(User.builder().userId(receiver.getUserId()).build())
                .content(content)
                .build();
    }
}
