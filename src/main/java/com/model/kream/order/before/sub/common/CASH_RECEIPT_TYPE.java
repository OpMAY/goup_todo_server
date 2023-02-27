package com.model.kream.order.before.sub.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CASH_RECEIPT_TYPE {
    NONE("미신청"), PHONE("개인소득공제(휴대폰)"), CARD("개인소득공제(현금영수증카드)");

    CASH_RECEIPT_TYPE(String keyword) {
        this.keyword = keyword;
    }
    private final String keyword;

    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }
}
