package com.cabbage16.fanspot.shared.response;

import com.cabbage16.fanspot.shared.error.ErrorProperty;

public record CommonResponse<T>(

        String code,
        String message,
        T data
) {
    public static <T> CommonResponse<T> ok(T data) {
        return new CommonResponse<>(
                "OK",
                "ok",
                data
        );
    }

    public static <T> CommonResponse<T> fail(ErrorProperty errorProperty, T data) {
        return new CommonResponse<>(
                errorProperty.name(),
                errorProperty.getMessage(),
                data
        );
    }

    public static <T> CommonResponse<T> fail(ErrorProperty errorProperty) {
        return new CommonResponse<>(
                errorProperty.name(),
                errorProperty.getMessage(),
                null
        );
    }
}
