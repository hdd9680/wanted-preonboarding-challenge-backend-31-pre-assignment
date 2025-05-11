package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.AccessLevel;
import lombok.Builder;
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

    @Builder
    public ProductImageDto(Long id, Long productId, String url, String altText, Boolean isPrimary, Integer displayOrder, Long productOptionId) {
        this.id = id;
        this.productId = productId;
        this.url = url;
        this.altText = altText;
        this.isPrimary = isPrimary;
        this.displayOrder = displayOrder;
        this.productOptionId = productOptionId;
    }
}
