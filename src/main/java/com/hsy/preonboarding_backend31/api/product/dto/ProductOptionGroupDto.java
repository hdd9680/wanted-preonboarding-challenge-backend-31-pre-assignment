package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOptionGroupDto {

    private Long id;
    private Long productId;
    private String name;
    private Integer displayOrder;

    private List<ProductOptionDto> options;

}
