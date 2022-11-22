package com.example.demo02.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("application.http-client.client-01")
@Setter
@Getter
public class ApplicationProperties {

    private String url;
    private Long connectTimeout;
    private Long readTimeout;
    private Long writeTimeout;
    private String key;
    
}
