package com.hsy.preonboarding_backend31.api.categories.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryDto {

    private Long id;

    private String name;
    private String slug;
    private String description;
    private Integer level;
    private String imageUrl;
    private Long parentId;

    @Builder
    public CategoryDto(Long id, String name, String slug, String description, Integer level, String imageUrl, Long parentId) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.level = level;
        this.imageUrl = imageUrl;
        this.parentId = parentId;
    }

}
