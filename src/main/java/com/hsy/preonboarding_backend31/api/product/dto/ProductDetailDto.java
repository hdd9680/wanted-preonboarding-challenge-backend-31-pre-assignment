package com.hsy.preonboarding_backend31.api.product.dto;

import com.hsy.preonboarding_backend31.api.product.entity.ProductDetail;
import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
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

    public static ProductDetailDto from(ProductDetail detail) {
        return ProductDetailDto.builder()
                .id(detail.getId())
                .weight(detail.getWeight())
                .dimensions(detail.getDimensions())
                .materials(detail.getMaterials())
                .countryOfOrigin(detail.getCountryOfOrigin())
                .warrantyInfo(detail.getWarrantyInfo())
                .careInstructions(detail.getCareInstructions())
                .additionalInfo(detail.getAdditionalInfo())
                .build();
    }
}
