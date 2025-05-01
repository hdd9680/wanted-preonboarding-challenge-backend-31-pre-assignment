package com.hsy.preonboarding_backend31.api.brand.dto;

import lombok.AccessLevel;
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

}
