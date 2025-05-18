package com.hsy.preonboarding_backend31.api.brand.dto;

import com.hsy.preonboarding_backend31.api.brand.entity.Brand;
import lombok.*;

@Data
@Builder
public class BrandDto {

    private Long id;
    private String name;
    private String slug;
    private String description;
    private String logoUrl;
    private String website;

    public static BrandDto from(Brand brand) {
        return BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .slug(brand.getSlug())
                .description(brand.getDescription())
                .logoUrl(brand.getLogoUrl())
                .website(brand.getWebsite())
                .build();
    }
}
