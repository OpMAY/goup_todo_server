package com.model.kream.cs;

import com.fasterxml.jackson.annotation.JsonValue;

public enum QNA_TYPE {
    POLICY("이용정책"), COMMON("공통"), SELL("판매"), BUY("구매");

    QNA_TYPE(String keyword) {
        this.keyword = keyword;
    }

    private final String keyword;

    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }

}
