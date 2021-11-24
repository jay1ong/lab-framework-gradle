package com.im.autoconfig.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.im.web.controller.RestControllerAdvice;
import com.im.web.controller.RestControllerProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/1
 */
@Configuration
@EnableConfigurationProperties(RestControllerProperties.class)
@ConditionalOnWebApplication
@ConditionalOnClass(RestControllerAdvice.class)
@AllArgsConstructor
public class RestControllerAutoConfiguration {

    private final RestControllerProperties properties;

    private final ObjectMapper objectMapper;

    @Bean
    public RestControllerAdvice restControllerAdvice() {
        return new RestControllerAdvice(properties, objectMapper);
    }

}
