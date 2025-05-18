package com.hsy.preonboarding_backend31.api.product.dto;

import com.hsy.preonboarding_backend31.api.product.entity.ProductCategory;
import lombok.*;

@Data
@Builder
public class ProductCategoryDto {

    private Long id;
    private Long productId;
    private Long categoryId;
    private Boolean isPrimary;

    public static ProductCategoryDto from(final ProductCategory productCategory) {
        return ProductCategoryDto.builder()
                .id(productCategory.getId())
                .productId(productCategory.getProduct().getId())
                .categoryId(productCategory.getCategory().getId())
                .isPrimary(productCategory.getIsPrimary())
                .build();
    }

}
