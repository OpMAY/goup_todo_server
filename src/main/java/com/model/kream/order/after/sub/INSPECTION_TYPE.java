package com.model.kream.order.after.sub;

import com.fasterxml.jackson.annotation.JsonValue;

public enum INSPECTION_TYPE {

    CHECKING("검수중"),// 검수중
    HOLDING("검수보류"),//검수보류
    SUCCESS("검수합격")// 검수합격
    ;


    INSPECTION_TYPE(String keyword) {
        this.keyword = keyword;
    }

    private String keyword;

    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }
}
