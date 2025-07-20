package com.cabbage16.fanspot.domain.auth.exception;

import com.cabbage16.fanspot.domain.auth.exception.error.AuthErrorProperty;
import com.cabbage16.fanspot.shared.error.CommonException;

public class InvalidTokenException extends CommonException {
    public InvalidTokenException() {
        super(AuthErrorProperty.INVALID_TOKEN);
    }
}
