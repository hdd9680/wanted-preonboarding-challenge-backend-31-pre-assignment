package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductPriceDto {

    private Long id;
    private Long productId;
    private BigDecimal basePrice;
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    private String currency;
    private BigDecimal taxRate;

    @Builder
    public ProductPriceDto(Long id, Long productId, BigDecimal basePrice, BigDecimal salePrice, BigDecimal costPrice
            , String currency, BigDecimal taxRate) {
        this.id = id;
        this.productId = productId;
        this.basePrice = basePrice;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
        this.currency = currency;
        this.taxRate = taxRate;
    }

}
