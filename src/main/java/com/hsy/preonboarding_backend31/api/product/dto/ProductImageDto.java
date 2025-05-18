package com.hsy.preonboarding_backend31.api.product.dto;

import com.hsy.preonboarding_backend31.api.product.entity.ProductImage;
import lombok.*;

@Data
@Builder
public class ProductImageDto {

    private Long id;
    private String url;
    private String altText;
    private Boolean isPrimary;
    private Integer displayOrder;
    private Long optionId;

    public static ProductImageDto from(ProductImage productImage) {
        return ProductImageDto.builder()
                .id(productImage.getId())
                .url(productImage.getUrl())
                .altText(productImage.getAltText())
                .isPrimary(productImage.getIsPrimary())
                .displayOrder(productImage.getDisplayOrder())
                .optionId(productImage.getOption().getId())
                .build();
    }
}
