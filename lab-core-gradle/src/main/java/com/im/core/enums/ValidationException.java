package com.im.core.enums;

import com.im.core.exception.IException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/16
 */
@Getter
@AllArgsConstructor
public enum ValidationException implements IException {
    // 策略模式异常
    PARAM_VALIDATE_FAIL("109993001", "参数验证失败"),

    ;
    private final String code;
    private final String message;
}
