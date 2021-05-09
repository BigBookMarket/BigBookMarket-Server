package com.bigbookmarket.domain;

import lombok.Getter;

@Getter
public enum ItemTradingMethod {
    Delivery(0), Direct(1), both(2);
    public int value;

    ItemTradingMethod(int m) {
        this.value = m;
    }
}
