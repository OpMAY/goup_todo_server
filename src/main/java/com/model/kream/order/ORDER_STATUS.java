package com.model.kream.order;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ORDER_STATUS {
    REGISTERED("접수 완료"),
    HOLDING("접수 보류"),
    FAIL("거래실패"),
    COMPLETE("정산완료");


    ORDER_STATUS(String keyword) {
        this.keyword = keyword;
    }

    private String keyword;

    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }

}
