package com.hsy.preonboarding_backend31.api.common.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class ApiException extends RuntimeException {

    private final Error error;

    public ApiException(HttpStatusCode errorCode, String message) {
        this.error = new Error(errorCode, message);
    }

    public boolean getSuccess() {
        return false;
    }

    @RequiredArgsConstructor
    @Getter
    private static class Error {
        private final HttpStatusCode code;
        private final String message;
    }

    public static ApiException notFound(String message) {
        return new ApiException(HttpStatus.NOT_FOUND, message);
    }

}
