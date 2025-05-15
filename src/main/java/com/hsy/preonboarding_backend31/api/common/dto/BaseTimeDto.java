package com.hsy.preonboarding_backend31.api.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseTimeDto extends BaseCreatedTimeDto {

    private LocalDateTime updatedAt;

}
