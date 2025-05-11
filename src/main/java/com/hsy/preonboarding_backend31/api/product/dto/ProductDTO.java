package com.hsy.preonboarding_backend31.api.product.dto;

import com.hsy.preonboarding_backend31.api.common.dto.BaseTimeDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    public static class RegistProductRequestDto {

        private final String name;
        private final String slug;
        private final String shortDescription;
        private final String fullDescription;
        private final long sellerId;
        private final long brandId;
        private final String status;

        private final ProductDetailDto detail;
        private final ProductPriceDto price;
        private final List<ProductCategoryDto> categories;
        private final List<ProductOptionGroupDto> optionGroups;
        private final List<ProductImageDto> images;
        private final List<Integer> tags;

        @Builder
        public RegistProductRequestDto(String name, String slug, String shortDescription, String fullDescription
                , int sellerId, int brandId, String status, ProductDetailDto detail, ProductPriceDto price
                , List<ProductCategoryDto> categories, List<ProductOptionGroupDto> optionGroups
                , List<ProductImageDto> images, List<Integer> tags) {
            this.name = name;
            this.slug = slug;
            this.shortDescription = shortDescription;
            this.fullDescription = fullDescription;
            this.sellerId = sellerId;
            this.brandId = brandId;
            this.status = status;
            this.detail = detail;
            this.price = price;
            this.categories = categories;
            this.optionGroups = optionGroups;
            this.images = images;
            this.tags = tags;
        }

    }

    @Getter
    public static class RegistProductResponseDto extends BaseTimeDto {

        private final Long id;
        private final String name;
        private final String slug;

        @Builder
        public RegistProductResponseDto(Long id, String name, String slug, LocalDateTime createdAt, LocalDateTime updatedAt) {
            super(createdAt, updatedAt);
            this.id = id;
            this.name = name;
            this.slug = slug;
        }
    }

}
