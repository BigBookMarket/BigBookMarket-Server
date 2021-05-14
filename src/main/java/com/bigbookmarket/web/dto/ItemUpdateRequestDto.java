package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.ItemTradingMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemUpdateRequestDto {

    private Integer price;
    private ItemTradingMethod method;
    private String detail;
}

