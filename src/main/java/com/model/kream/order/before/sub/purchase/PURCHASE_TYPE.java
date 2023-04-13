package com.model.kream.order.before.sub.purchase;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PURCHASE_TYPE {
    DIRECT("다이렉트"),
    AUCTION("옥션");

    PURCHASE_TYPE(String keyword) {
        this.keyword = keyword;
    }

    private String keyword;

    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }
}
