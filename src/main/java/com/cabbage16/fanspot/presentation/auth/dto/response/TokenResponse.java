package com.cabbage16.fanspot.presentation.auth.dto.response;

public record TokenResponse(

        String accessToken,
        String refreshToken
) {
}
