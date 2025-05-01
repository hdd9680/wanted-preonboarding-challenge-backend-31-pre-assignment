package com.hsy.preonboarding_backend31.api.seller.dto;

import com.hsy.preonboarding_backend31.api.common.dto.BaseCreatedTimeDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
