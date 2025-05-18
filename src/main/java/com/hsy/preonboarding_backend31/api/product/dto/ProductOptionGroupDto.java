package com.hsy.preonboarding_backend31.api.product.dto;

import com.hsy.preonboarding_backend31.api.product.entity.ProductOptionGroup;
import lombok.*;

import java.util.List;

@Data
@Builder
public class ProductOptionGroupDto {

    private Long id;
    private Long productId;
    private String name;
    private Integer displayOrder;

    private List<ProductOptionDto> options;

    public static ProductOptionGroupDto from(ProductOptionGroup productOptionGroup) {
        return ProductOptionGroupDto.builder()
                .id(productOptionGroup.getId())
                .productId(productOptionGroup.getProduct().getId())
                .name(productOptionGroup.getName())
                .displayOrder(productOptionGroup.getDisplayOrder())
                .options(productOptionGroup.getOptions().stream().map(ProductOptionDto::from).toList())
                .build();
    }
}
