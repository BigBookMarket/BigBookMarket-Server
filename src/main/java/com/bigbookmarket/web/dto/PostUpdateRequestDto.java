package com.bigbookmarket.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {

    private String title;
    private String content;

    // TODO: post update할 때 title과 content만 변경가능하게 할건지? (category)
}
