package com.cabbage16.fanspot.domain.auth.domain.type;

import com.cabbage16.fanspot.shared.enums.EnumProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TokenType implements EnumProperty {

    ACCESS_TOKEN("액세스 토큰"),
    REFRESH_TOKEN("리프레시 토큰");

    private final String description;
}
