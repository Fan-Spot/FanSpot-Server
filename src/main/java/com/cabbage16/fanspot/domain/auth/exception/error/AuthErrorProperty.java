package com.cabbage16.fanspot.domain.auth.exception.error;

import com.cabbage16.fanspot.shared.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthErrorProperty implements ErrorProperty {

    EMPTY_TOKEN(HttpStatus.UNAUTHORIZED, "인증이 필요합니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 만료되었습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 유효하지 않습니다."),
    EXPIRED_GOOGLE_ID_TOKEN(HttpStatus.UNAUTHORIZED, "Google ID 토큰이 만료되었습니다.")
    ;

    private final HttpStatus status;
    private final String message;
}
