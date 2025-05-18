package com.hsy.preonboarding_backend31.api.tags.dto;

import com.hsy.preonboarding_backend31.api.tags.entity.Tag;
import lombok.*;

@Data
@Builder
public class TagDto {

    private Long id;
    private String name;
    private String slug;

    public static TagDto from(Tag tag) {
        return TagDto.builder()
                .id(tag.getId())
                .name(tag.getName())
                .slug(tag.getSlug())
                .build();
    }
}
