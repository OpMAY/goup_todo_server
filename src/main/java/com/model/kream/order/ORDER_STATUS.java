package com.model.kream.order;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ORDER_STATUS {
    REGISTERED("등록완료"),
    HOLDING("보류"),
    FAIL("거래실패");


    ORDER_STATUS(String keyword) {
        this.keyword = keyword;
    }

    private String keyword;

    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }

}
