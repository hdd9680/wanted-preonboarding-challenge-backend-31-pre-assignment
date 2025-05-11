package com.hsy.preonboarding_backend31.api.common.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseCreatedTimeDto {

    private final LocalDateTime createdAt;

    public BaseCreatedTimeDto() {
        this.createdAt = LocalDateTime.now();
    }

    public BaseCreatedTimeDto(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
