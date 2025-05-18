package com.hsy.preonboarding_backend31.api.categories.dto;

import com.hsy.preonboarding_backend31.api.categories.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

    private Long id;

    private String name;
    private String slug;
    private String description;
    private Integer level;
    private String imageUrl;
    private Long parentId;
    private ParentCategoryDto parent;

    @Data
    @Builder
    public static class ParentCategoryDto {
        private Long id;
        private String name;
        private String slug;

        public static ParentCategoryDto from(Category category) {
            return ParentCategoryDto.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .slug(category.getSlug())
                    .build();
        }
    }

    public static CategoryDto from(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .slug(category.getSlug())
                .description(category.getDescription())
                .level(category.getLevel())
                .imageUrl(category.getImageUrl())
                .parent(ParentCategoryDto.from(category.getParent()))
                .build();
    }
}
