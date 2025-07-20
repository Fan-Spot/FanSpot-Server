package com.cabbage16.fanspot.domain.auth.exception;

import com.cabbage16.fanspot.domain.auth.exception.error.AuthErrorProperty;
import com.cabbage16.fanspot.shared.error.CommonException;

public class ExpiredTokenException extends CommonException {
    public ExpiredTokenException() {
        super(AuthErrorProperty.EXPIRED_TOKEN);
    }
}
