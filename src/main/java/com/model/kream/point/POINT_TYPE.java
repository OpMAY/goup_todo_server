package com.model.kream.point;

import com.fasterxml.jackson.annotation.JsonValue;


public enum POINT_TYPE {
    ACCUMULATE("적립"), USED("사용"), EXPIRED("만료");

    POINT_TYPE(String keyword) {
        this.keyword = keyword;
    }
    private final String keyword;

    // JsonValue annotation을 통해 Json에 데이터 넣을 시 ENUM이 아닌 해당 값으로 전달됨
    // private POINT_TYPE type => type = USED (x) / type = "사용"
    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }
}
