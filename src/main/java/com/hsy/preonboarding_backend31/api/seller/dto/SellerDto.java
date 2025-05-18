package com.hsy.preonboarding_backend31.api.seller.dto;

import com.hsy.preonboarding_backend31.api.common.dto.BaseCreatedTimeDto;
import com.hsy.preonboarding_backend31.api.seller.entity.Seller;
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

    public static SellerDto from(final Seller seller) {
        return SellerDto.builder()
                .id(seller.getId())
                .name(seller.getName())
                .description(seller.getDescription())
                .logoUrl(seller.getLogoUrl())
                .rating(seller.getRating())
                .contactEmail(seller.getContactEmail())
                .contactPhone(seller.getContactPhone())
                .createdAt(seller.getCreatedAt())
                .build();
    }

}
