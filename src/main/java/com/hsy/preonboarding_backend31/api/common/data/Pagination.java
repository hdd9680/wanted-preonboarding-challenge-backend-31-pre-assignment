package com.hsy.preonboarding_backend31.api.common.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Pagination {

    private final int page = 1;
    private final int perPage = 10;

}
