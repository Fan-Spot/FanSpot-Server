package com.cabbage16.fanspot.domain.auth.exception;

import com.cabbage16.fanspot.domain.auth.exception.error.AuthErrorProperty;
import com.cabbage16.fanspot.shared.error.CommonException;

public class ExpiredGoogleIdTokenException extends CommonException {
    public ExpiredGoogleIdTokenException() {
        super(AuthErrorProperty.EXPIRED_GOOGLE_ID_TOKEN);
    }
}
