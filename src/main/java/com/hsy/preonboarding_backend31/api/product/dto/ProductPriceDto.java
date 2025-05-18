package com.hsy.preonboarding_backend31.api.product.dto;

import com.hsy.preonboarding_backend31.api.product.entity.ProductPrice;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
public class ProductPriceDto {

    private Long id;
    private Long productId;
    private BigDecimal basePrice;
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    private String currency;
    private BigDecimal taxRate;

    public static ProductPriceDto from(ProductPrice price) {
        return ProductPriceDto.builder()
                .id(price.getId())
                .productId(price.getProduct().getId())
                .basePrice(price.getBasePrice())
                .salePrice(price.getSalePrice())
                .costPrice(price.getCostPrice())
                .currency(price.getCurrency())
                .taxRate(price.getTaxRate())
                .build();
    }
}
