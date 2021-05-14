package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Item;
import com.bigbookmarket.domain.ItemTradingMethod;
import com.bigbookmarket.domain.ItemTradingStatus;
import lombok.Getter;

@Getter
public class ItemResponseDto {
    private Long itemId;
    private Book book;
    private Long userId;
    private String nickname;
    private Integer price;
    private ItemTradingMethod method;
    private ItemTradingStatus status;
    private String detail;
    private String createdDate;

    public ItemResponseDto(Item entity) {
        this.itemId = entity.getItemId();
        this.book = entity.getBook();
        this.userId = entity.getUser().getUserId();
        this.nickname = entity.getUser().getNickname();
        this.price = entity.getPrice();
        this.method = entity.getMethod();
        this.status = entity.getStatus();
        this.detail = entity.getDetail();
        this.createdDate = entity.getCreatedDate().toString();
    }
}
