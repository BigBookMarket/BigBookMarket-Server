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
    private ItemTradingStatus status;
    private String detail;

    public Item toEntity() {
        return Item.builder()
                .book(book)
                .seller(User.builder().userId(sellerId).build())
                .price(price)
                .method(method)
                .status(status)
                .detail(detail)
                .status(ItemTradingStatus.SALE)
                .build();
    }
}
