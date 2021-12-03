package cn.jaylong.core.enums;

import cn.jaylong.core.exception.IException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/15
 */
@Getter
@AllArgsConstructor
public enum StrategyException implements IException {
    // 策略模式异常
    STRATEGY_NOT_FOUND("109991001", "未找到指定的扩展实例"),

    ;
    private final String code;
    private final String message;
}