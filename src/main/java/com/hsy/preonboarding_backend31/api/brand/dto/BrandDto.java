package com.hsy.preonboarding_backend31.api.brand.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BrandDto {

    private Long id;
    private String name;
    private String slug;
    private String description;
    private String logoUrl;
    private String website;

    @Builder
    public BrandDto(Long id, String name, String slug, String description, String logoUrl, String website) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.logoUrl = logoUrl;
        this.website = website;
    }

}
