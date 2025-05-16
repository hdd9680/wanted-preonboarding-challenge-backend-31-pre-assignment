package com.hsy.preonboarding_backend31.api.seller.dto;

import com.hsy.preonboarding_backend31.api.common.dto.BaseCreatedTimeDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class SellerDto extends BaseCreatedTimeDto {

    private Long id;
    private String name;
    private String description;
    private String logoUrl;
    private BigDecimal rating;
    private String contactEmail;
    private String contactPhone;
    private LocalDateTime createdAt;

}
