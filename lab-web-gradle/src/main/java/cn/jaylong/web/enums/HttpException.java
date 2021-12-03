package cn.jaylong.web.enums;

import cn.jaylong.core.exception.IException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/3
 */
@Getter
@AllArgsConstructor
public enum HttpException implements IException {
    // 登录异常
    HTTP_ERROR("109990001", "http请求异常"),

    ;
    private final String code;
    private final String message;
}
