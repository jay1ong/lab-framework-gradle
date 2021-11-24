package com.im.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.im.core.exception.BizException;
import com.im.core.net.ApiMessage;
import com.im.web.OriginResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/1
 */
@ControllerAdvice
@AllArgsConstructor
public class RestControllerAdvice implements ResponseBodyAdvice<Object> {

    private final RestControllerProperties properties;

    private final ObjectMapper objectMapper;

    @ExceptionHandler(BizException.class)
    public ResponseEntity<?> bizException(BizException ex, WebRequest request) {
        ApiMessage message = new ApiMessage();
        message.setCode(ex.getCode());
        message.setTimestamp(LocalDateTime.now());
        message.setMessage(ex.getMessage());
        message.setDescription(request.getDescription(false));
        return ResponseEntity.ok(message);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
//        ApiMessage message = new ApiMessage();
//        message.setCode("11000");
//        message.setTimestamp(LocalDateTime.now());
//        message.setMessage(ex.getMessage());
//        message.setDescription(request.getDescription(false));
//        return ResponseEntity.ok(message);
//    }

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return filter(returnType);
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (body instanceof ApiMessage) {
            return body;
        }
        ApiMessage message = new ApiMessage();
        message.setCode("200");
        message.setTimestamp(LocalDateTime.now());
        message.setData(body);
        response.getHeaders().set("Content-Type", "application/json;charset=utf-8");
        return body instanceof String ? objectMapper.writeValueAsString(message) : message;
    }

    public boolean filter(MethodParameter returnType) {
        Class<?> declaringClass = returnType.getDeclaringClass();
        Method method = returnType.getMethod();
        if (method == null) {
            return false;
        }
        if (declaringClass.isAnnotationPresent(OriginResponse.class)) {
            return false;
        }
        if (method.isAnnotationPresent(OriginResponse.class)) {
            return false;
        }
        return properties.enabled;
    }

}
