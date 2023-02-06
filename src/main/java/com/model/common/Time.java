package com.model.common;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class Time {

    private LocalDateTime regDatetime;
    private LocalDateTime updatedDatetime;

    public Time() {

    }

    public Time(LocalDateTime regDatetime, LocalDateTime updatedDatetime) {
        this.regDatetime = regDatetime;
        this.updatedDatetime = updatedDatetime;
    }
}
