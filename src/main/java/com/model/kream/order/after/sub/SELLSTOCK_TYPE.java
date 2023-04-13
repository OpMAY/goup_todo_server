package com.model.kream.order.after.sub;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SELLSTOCK_TYPE {

    A("발송완료"),
    B("발송요청"),
    C("입고대기"),
    D("입고완료");

    SELLSTOCK_TYPE(String keyword) {
        this.keyword = keyword;
    }

    private String keyword;

    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }

    }
