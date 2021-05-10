package com.bigbookmarket.domain;

import lombok.Getter;

@Getter
public enum ItemTradingMethod {
    DELIVERY(0), DIRECT(1), BOTH(2);
    public int value;

    ItemTradingMethod(int m) {
        this.value = m;
    }
}
