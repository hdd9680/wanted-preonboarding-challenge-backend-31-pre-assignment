package com.hsy.preonboarding_backend31.api.user.dto;

import com.hsy.preonboarding_backend31.api.common.dto.BaseCreatedTimeDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseCreatedTimeDto {

    private Long id;
    private String name;
    private String email;
    private String avatarUrl;

}
