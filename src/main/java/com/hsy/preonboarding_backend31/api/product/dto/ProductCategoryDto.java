package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductCategoryDto {

    private Long id;
    private Long productId;
    private Long categoryId;
    private Boolean isPrimary;
}
