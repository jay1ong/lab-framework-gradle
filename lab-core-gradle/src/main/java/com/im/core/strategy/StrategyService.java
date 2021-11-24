package com.im.core.strategy;

import cn.hutool.core.util.ReflectUtil;
import com.im.core.enums.StrategyException;
import com.im.core.exception.BizException;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/12
 */
@Service
public class StrategyService {

    private final Map<String, Object> map;

    public StrategyService(ApplicationContext context) {
        this.map = context.getBeansWithAnnotation(Strategy.class);
    }

    @SneakyThrows
    public <I extends IStrategy> I getStrategy(Class<I> clazz, Object param) {
        Class<?> iStrategyClass = Class.forName("com.im.core.strategy.IStrategy");
        for (Object o :
                this.map.values()) {
            Class<?>[] interfaces = o.getClass().getInterfaces();
            Optional<Class<?>> optionalClass = Arrays.stream(interfaces).filter(it -> it.getName().equals(clazz.getName())).findFirst();
            if (optionalClass.isPresent()) {
                Method[] methods = ReflectUtil.getMethods(o.getClass());
                Set<Method> methodSet = Arrays.stream(methods).filter(it -> iStrategyClass.getMethods()[0].getName().equals(it.getName())).collect(Collectors.toSet());
                if (!methodSet.isEmpty()) {
                    for (Method method :
                            methodSet) {
                        Optional<Class<?>> classOptional = Arrays.stream(method.getParameterTypes())
                                .sorted()
                                .filter(it -> !it.getName().equals("java.lang.Object") && it.isInstance(param)).findFirst();
                        if (classOptional.isPresent() && ((I) o).match(param)) {
                            return ((I) o);
                        }
                    }
                }
            }
        }
        throw new BizException(StrategyException.STRATEGY_NOT_FOUND);
    }

}
