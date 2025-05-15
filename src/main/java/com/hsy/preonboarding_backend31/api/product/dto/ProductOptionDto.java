package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOptionDto {

    private Long id;
    private Long optionGroupId;
    private String name;
    private BigDecimal additionalPrice;
    private String sku;
    private Integer stock;
    private Integer displayOrder;

}
