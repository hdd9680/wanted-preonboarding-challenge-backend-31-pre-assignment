package com.hsy.preonboarding_backend31.api.user.dto;

import com.hsy.preonboarding_backend31.api.common.dto.BaseCreatedTimeDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto extends BaseCreatedTimeDto {

    private Long id;
    private String name;
    private String email;
    private String avatarUrl;

}
