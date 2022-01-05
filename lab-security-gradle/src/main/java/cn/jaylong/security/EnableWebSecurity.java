package cn.jaylong.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/1/5
 * Url: jaylong.cn
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({WebSecurityConfig.class})
@Configuration
public @interface EnableWebSecurity {
}
