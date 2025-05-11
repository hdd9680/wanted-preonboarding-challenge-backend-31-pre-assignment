package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDetailDto {

    private Long id;
    private Long productId;
    private BigDecimal weight;
    private Map<String, Object> dimensions;
    private String materials;
    private String countryOfOrigin;
    private String warrantyInfo;
    private String careInstructions;
    private Map<String, Object> additionalInfo;

    @Builder
    public ProductDetailDto(Long id, Long productId, BigDecimal weight, Map<String, Object> dimensions, String materials
            , String countryOfOrigin, String warrantyInfo, String careInstructions, Map<String, Object> additionalInfo) {
        this.id = id;
        this.productId = productId;
        this.weight = weight;
        this.dimensions = dimensions;
        this.materials = materials;
        this.countryOfOrigin = countryOfOrigin;
        this.warrantyInfo = warrantyInfo;
        this.careInstructions = careInstructions;
        this.additionalInfo = additionalInfo;
    }

}
