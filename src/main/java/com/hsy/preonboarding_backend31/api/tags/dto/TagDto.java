package com.hsy.preonboarding_backend31.api.tags.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TagDto {

    private Long id;
    private String name;
    private String slug;

}
