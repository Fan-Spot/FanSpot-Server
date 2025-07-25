package com.cabbage16.fanspot.shared.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private Long accessExpirationTime;
    private Long refreshExpirationTime;
    private String prefix;
    private String secret;
}
