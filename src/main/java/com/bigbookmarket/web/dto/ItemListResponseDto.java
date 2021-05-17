package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Item;
import com.bigbookmarket.domain.ItemTradingMethod;
import com.bigbookmarket.domain.ItemTradingStatus;
import lombok.Getter;

@Getter
public class ItemListResponseDto {

    private Long itemId;
    private Book book;
    private String nickname;
    private Integer price;
    private ItemTradingMethod method;
    private ItemTradingStatus status;
    private String createdDate;

    public ItemListResponseDto(Item entity) {
        this.itemId = entity.getItemId();
        this.book = entity.getBook();
        this.nickname = entity.getUser().getNickname();
        this.price = entity.getPrice();
        this.method = entity.getMethod();
        this.status = entity.getStatus();
        this.createdDate = entity.getCreatedDate().toString();
    }
}
