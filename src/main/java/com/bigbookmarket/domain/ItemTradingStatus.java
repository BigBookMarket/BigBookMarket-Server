package com.bigbookmarket.domain;

import lombok.Getter;

@Getter
public enum ItemTradingStatus {
    SALE(0), DEAL(1), SOLD(2);
    public int value;

    ItemTradingStatus(int s) {
        this.value = s;
    }
}
