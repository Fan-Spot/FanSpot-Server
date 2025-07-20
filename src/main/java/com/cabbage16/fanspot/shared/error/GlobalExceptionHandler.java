package com.cabbage16.fanspot.shared.error;

import com.cabbage16.fanspot.shared.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<CommonResponse<ErrorProperty>> handleCommonException(CommonException e) {
        warn(e);

        return ResponseEntity
                .status(e.getErrorProperty().getStatus())
                .body(CommonResponse.fail(e.getErrorProperty()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse<ErrorProperty>> handleException(Exception e) {
        log.error(e.getMessage(), e);

        return ResponseEntity
                .status(GlobalErrorProperty.INTERNAL_SERVER_ERROR.getStatus())
                .body(CommonResponse.fail(GlobalErrorProperty.INTERNAL_SERVER_ERROR));
    }

    private void warn(Exception e) {
        log.warn("Resolved [{}: {}]", e.getClass().getName(), e.getMessage());
    }
}
