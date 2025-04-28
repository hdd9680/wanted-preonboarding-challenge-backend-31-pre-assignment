package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.common.data;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
public class ApiResponse<T> {

    private final String message;
    private final T data;

    public ApiResponse(final String message, final T data) {
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<PaginationData<T>> success(
            final String message,
            final List<T> items,
            final Pagination pagination,
            final int totalItems
    ) {
        int currentPage = pagination.getPage();
        int perPage = pagination.getPerPage();
        int totalPages = totalItems / perPage;

        PaginationResponse paginationResponse = new PaginationResponse(totalItems, totalPages, currentPage, perPage);
        PaginationData<T> paginationData = new PaginationData<>(items, paginationResponse);
        return new ApiResponse<>(message, paginationData);
    }

    public static <T> ApiResponse<T> success(final String message, final T data) {
        return new ApiResponse<T>(message, data);
    }

    public static ApiResponse<EmptyData> success(final String message) {
        return new ApiResponse<EmptyData>(message, null);
    }

    public boolean getSuccess() {
        return true;
    }

    public static class EmptyData {}

    @RequiredArgsConstructor
    @Getter
    public static class PaginationData<T> {

        private final List<T> items;
        private final PaginationResponse pagination;

    }

    @RequiredArgsConstructor
    @Getter
    private static class PaginationResponse {

        @JsonAlias("total_items")
        private final int totalItems;

        @JsonAlias("total_pages")
        private final int totalPages;

        @JsonAlias("current_page")
        private final int currentPage;

        @JsonAlias("per_page")
        private final int perPage;

    }
}
