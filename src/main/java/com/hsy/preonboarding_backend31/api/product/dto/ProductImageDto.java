package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImageDto {

    private Long id;
    private Long productId;
    private String url;
    private String altText;
    private Boolean isPrimary;
    private Integer displayOrder;
    private Long productOptionId;
    private Long optionId;

}
