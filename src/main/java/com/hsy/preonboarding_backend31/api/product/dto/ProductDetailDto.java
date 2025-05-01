package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.AccessLevel;
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
    private Map<String, Object> dimension;
    private String materials;
    private String countryOfOrigin;
    private String warrantyInfo;
    private String careInstructions;
    private Map<String, Object> additionalInfo;

}
