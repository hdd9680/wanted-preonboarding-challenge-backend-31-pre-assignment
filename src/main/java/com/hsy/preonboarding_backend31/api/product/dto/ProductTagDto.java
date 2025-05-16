package com.hsy.preonboarding_backend31.api.product.dto;

import lombok.*;

@Data
@Builder
public class ProductTagDto {

    private Long id;
    private Long productId;
    private Long tagId;

}
