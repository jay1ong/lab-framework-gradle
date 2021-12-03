package cn.jaylong.web;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/16
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface OriginResponse {
}
