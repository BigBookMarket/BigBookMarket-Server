package com.bigbookmarket.domain;

import lombok.Getter;

@Getter
public enum ItemTradingStatus {
    Sale(0), deal(1), sold(2);
    public int value;

    ItemTradingStatus(int s) {
        this.value = s;
    }
}
