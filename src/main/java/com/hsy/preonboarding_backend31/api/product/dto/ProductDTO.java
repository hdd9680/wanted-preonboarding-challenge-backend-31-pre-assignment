package com.hsy.preonboarding_backend31.api.product.dto;

import com.hsy.preonboarding_backend31.api.common.dto.BaseTimeDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDTO extends BaseTimeDto {

    private int id;
    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private int sellerId;
    private int brandId;
    private String status;

    @Getter
    public static class RegistProductDto {

        private String name;
        private String slug;
        private String shortDescription;
        private String fullDescription;
        private int sellerId;
        private int brandId;
        private String status;

        private ProductDetailDto detail;
        private ProductPriceDto price;
        private List<ProductCategoryDto> categories;
        private List<ProductOptionGroupDto> optionGroups;
        private List<ProductImageDto> images;
        private List<Integer> tags;
    }

}
