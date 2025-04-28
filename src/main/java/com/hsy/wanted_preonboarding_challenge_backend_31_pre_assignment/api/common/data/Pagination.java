package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.common.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Pagination {

    private final int page = 1;
    private final int perPage = 10;

}
