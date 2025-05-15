package com.hsy.preonboarding_backend31.api.categories.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Long id;

    private String name;
    private String slug;
    private String description;
    private Integer level;
    private String imageUrl;
    private Long parentId;

}
