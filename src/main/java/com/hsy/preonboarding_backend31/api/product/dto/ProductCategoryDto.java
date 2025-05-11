package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductCategoryDto {

    private Long id;
    private Long productId;
    private Long categoryId;
    private Boolean isPrimary;

    @Builder
    public ProductCategoryDto(Long id, Long productId, Long categoryId, Boolean isPrimary) {
        this.id = id;
        this.productId = productId;
        this.categoryId = categoryId;
        this.isPrimary = isPrimary;
    }

}
