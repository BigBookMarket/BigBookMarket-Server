package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemSaveRequestDto {

    private Book book;
    private Long sellerId;
    private Integer price;
    private ItemTradingMethod method;
    private String detail;

    public Item toEntity() {
        return Item.builder()
                .book(book)
                .user(User.builder().userId(sellerId).build())
                .price(price)
                .method(method)
                .detail(detail)
                .status(ItemTradingStatus.SALE)
                .build();
    }
}
