package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategoryDto {

    private Long id;
    private Long productId;
    private Long categoryId;
    private Boolean isPrimary;

}
