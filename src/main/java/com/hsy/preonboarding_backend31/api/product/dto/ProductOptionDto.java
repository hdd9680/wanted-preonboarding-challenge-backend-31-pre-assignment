package com.hsy.preonboarding_backend31.api.product.dto;

import com.hsy.preonboarding_backend31.api.product.entity.ProductOption;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class ProductOptionDto {

    private Long id;
    private Long optionGroupId;
    private String name;
    private BigDecimal additionalPrice;
    private String sku;
    private Integer stock;
    private Integer displayOrder;

    public static ProductOptionDto from(ProductOption productOption) {
        return ProductOptionDto.builder()
                .id(productOption.getId())
                .name(productOption.getName())
                .additionalPrice(productOption.getAdditionalPrice())
                .sku(productOption.getSku())
                .stock(productOption.getStock())
                .displayOrder(productOption.getDisplayOrder())
                .build();
    }
}
