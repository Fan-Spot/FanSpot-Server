package com.cabbage16.fanspot.shared.error;

import org.springframework.http.HttpStatus;

public interface ErrorProperty {

    HttpStatus getStatus();
    String getMessage();
    String name();
}
