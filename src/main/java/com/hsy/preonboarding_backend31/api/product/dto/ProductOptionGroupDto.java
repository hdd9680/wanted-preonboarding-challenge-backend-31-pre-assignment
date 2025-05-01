package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductOptionGroupDto {

    private Long id;
    private Long productId;
    private String name;
    private Integer displayOrder;

    private List<ProductOptionDto> options;
}
