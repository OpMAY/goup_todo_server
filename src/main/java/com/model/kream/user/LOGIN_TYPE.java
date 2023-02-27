package com.model.kream.user;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LOGIN_TYPE {
    KAKAO("카카오"), NAVER("네이버"), GOOGLE("구글");

    LOGIN_TYPE(String keyword) {
        this.keyword = keyword;
    }

    private final String keyword;

    @JsonValue
    public String getKeyword() {
        return this.keyword;
    }

}
