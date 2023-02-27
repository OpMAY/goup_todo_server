package com.model.kream.order.before.sub.sell;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SELL_TYPE {
    DIRECT("즉시 판매"), AUCTION("판매 입찰");

    SELL_TYPE(String keyword) {
        this.keyword = keyword;
    }
    private final String keyword;

    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }
}
