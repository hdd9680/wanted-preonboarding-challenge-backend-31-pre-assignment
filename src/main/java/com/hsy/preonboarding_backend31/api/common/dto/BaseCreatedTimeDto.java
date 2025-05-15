package com.hsy.preonboarding_backend31.api.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
public class BaseCreatedTimeDto {

    private LocalDateTime createdAt;

}
