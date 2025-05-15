package com.hsy.preonboarding_backend31.api.tags.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagDto {

    private Long id;
    private String name;
    private String slug;

}
