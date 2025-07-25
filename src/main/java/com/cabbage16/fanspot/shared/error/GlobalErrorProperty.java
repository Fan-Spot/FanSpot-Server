package com.cabbage16.fanspot.shared.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum GlobalErrorProperty implements ErrorProperty {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다. 다시 한 번 확인해주세요."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 알 수 없는 에러가 발생했습니다.")
    ;

    private final HttpStatus status;
    private final String message;
}
