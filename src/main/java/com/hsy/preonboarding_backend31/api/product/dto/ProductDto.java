package com.hsy.preonboarding_backend31.api.product.dto;

import com.hsy.preonboarding_backend31.api.brand.dto.BrandDto;
import com.hsy.preonboarding_backend31.api.categories.dto.CategoryDto;
import com.hsy.preonboarding_backend31.api.common.dto.BaseTimeDto;
import com.hsy.preonboarding_backend31.api.product.entity.Product;
import com.hsy.preonboarding_backend31.api.seller.dto.SellerDto;
import com.hsy.preonboarding_backend31.api.tags.dto.TagDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@SuperBuilder
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
    @Builder
    public static class ModifyProductRequestDto {

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
        private List<Long> tagIds;

    }

    @Data
    @SuperBuilder
    @EqualsAndHashCode(callSuper = true)
    public static class ProductResponseDto extends BaseTimeDto {

        private Long id;
        private String name;
        private String slug;
        private String shortDescription;
        private String fullDescription;
        private SellerDto seller;
        private BrandDto brand;
        private String status;
        private ProductDetailDto detail;
        private ProductPriceDto price;
        private List<CategoryDto> categories;
        private List<ProductOptionGroupDto> optionGroups;
        private List<ProductImageDto> images;
        private List<TagDto> tags;
        private RatingSummary rating;
        private List<ProductSummary> relatedProducts;

        public static ProductResponseDto from(Product product) {
            return ProductResponseDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .slug(product.getSlug())
                    .shortDescription(product.getShortDescription())
                    .fullDescription(product.getFullDescription())
                    .status(product.getStatus())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt())
                    .seller(SellerDto.from(product.getSeller()))
                    .brand(BrandDto.from(product.getBrand()))
                    .detail(ProductDetailDto.from(product.getDetail()))
                    .price(ProductPriceDto.from(product.getPrice()))
                    .categories(product.getCategories().stream().map(CategoryDto::from).toList())
                    .optionGroups(product.getOptionGroups().stream().map(ProductOptionGroupDto::from).toList())
                    .images(product.getImages().stream().map(ProductImageDto::from).toList())
                    .tags(product.getTags().stream().map(TagDto::from).toList())
                    .build();
        }
    }

    @Data
    @Builder
    public static class RatingSummary {
        private Double average;
        private Integer count;
        private Map<Integer, Integer> distribution; // Map rating -> count (e.g., {5: 95, 4: 20, ...})
    }

    @Data
    @Builder
    public static class ProductSummary {
        private Long id;
        private String name;
        private String slug;
        private String shortDescription;
        private BigDecimal basePrice;
        private BigDecimal salePrice;
        private String currency;
        private ProductImageDto primaryImage;
        private BrandDto brand;
        private SellerDto seller;
        private Double rating;
        private Integer reviewCount;
        private boolean inStock;
        private String status;
        private LocalDateTime createdAt;
    }

}
