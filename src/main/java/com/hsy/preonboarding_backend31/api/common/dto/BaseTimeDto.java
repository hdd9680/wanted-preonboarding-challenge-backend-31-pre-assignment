package com.hsy.preonboarding_backend31.api.common.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BaseTimeDto extends BaseCreatedTimeDto {

    private final LocalDateTime updatedAt;

    public BaseTimeDto() {
        super();
        this.updatedAt = LocalDateTime.now();
    }

    public BaseTimeDto(LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt);
        this.updatedAt = updatedAt;
    }

}
