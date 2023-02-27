package com.model.kream.order.after.sub;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DELIVERY_STATUS {
    DELIVERY_READY("배송 준비"), ON_DELIVERY("배송 중"), DELIVERY_FINISHED("배송 완료");

    DELIVERY_STATUS(String keyword) {
        this.keyword = keyword;
    }
    private final String keyword;

    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }
}
