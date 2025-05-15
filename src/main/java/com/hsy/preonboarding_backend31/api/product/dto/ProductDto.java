package com.hsy.preonboarding_backend31.api.product.dto;

import com.hsy.preonboarding_backend31.api.common.dto.BaseTimeDto;
import com.hsy.preonboarding_backend31.api.product.entity.Product;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductDto extends BaseTimeDto {

    private int id;
    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private int sellerId;
    private int brandId;
    private String status;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class RegistProductRequestDto {

        private String name;
        private String slug;
        private String shortDescription;
        private String fullDescription;
        private Long sellerId;
        private Long brandId;
        private String status;

        private ProductDetailDto detail;
        private ProductPriceDto price;
        private List<ProductCategoryDto> categories;
        private List<ProductOptionGroupDto> optionGroups;
        private List<ProductImageDto> images;
        private List<Long> tags;

    }

    @Data
    @SuperBuilder
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    public static class RegistProductResponseDto extends BaseTimeDto {

        private Long id;
        private String name;
        private String slug;

        public static RegistProductResponseDto of(Product product) {
            return ProductDto.RegistProductResponseDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .slug(product.getSlug())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt())
                    .build();
        }
    }

}
