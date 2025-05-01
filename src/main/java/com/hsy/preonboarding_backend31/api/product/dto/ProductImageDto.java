package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImageDto {

    private Long id;
    private Long productId;
    private String url;
    private String altText;
    private Boolean isPrimary;
    private Integer displayOrder;
    private Long productOptionId;

}
