package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import com.bigbookmarket.domain.Item;
import com.bigbookmarket.domain.ItemTradingMethod;
import com.bigbookmarket.domain.ItemTradingStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ItemResponseDto {
    private Long itemId;
    private Book book;
    private String sellerId;
    private String sellerNickname;
    private String buyerId;
    private String buyerNickname;
    private Integer price;
    private ItemTradingMethod method;
    private ItemTradingStatus status;
    private String detail;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    public ItemResponseDto(Item entity) {
        this.itemId = entity.getItemId();
        this.book = entity.getBook();
        this.sellerId = entity.getSeller().getId();
        this.sellerNickname = entity.getSeller().getNickname();
        if (entity.getBuyer() != null) {
            this.buyerId = entity.getBuyer().getId();
            this.buyerNickname = entity.getBuyer().getNickname();
        }
        this.price = entity.getPrice();
        this.method = entity.getMethod();
        this.status = entity.getStatus();
        this.detail = entity.getDetail();
        this.createdDate = entity.getCreatedDate();
    }
}
