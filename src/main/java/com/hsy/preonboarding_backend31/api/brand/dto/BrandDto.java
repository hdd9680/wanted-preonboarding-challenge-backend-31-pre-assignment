package com.hsy.preonboarding_backend31.api.brand.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandDto {

    private Long id;
    private String name;
    private String slug;
    private String description;
    private String logoUrl;
    private String website;

}
