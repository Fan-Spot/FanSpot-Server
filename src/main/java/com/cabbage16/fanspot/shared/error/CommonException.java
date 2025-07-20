package com.cabbage16.fanspot.shared.error;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

    private final ErrorProperty errorProperty;

    public CommonException(ErrorProperty errorProperty) {
        super(errorProperty.getMessage());
        this.errorProperty = errorProperty;
    }
}
