package cn.jaylong.test.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/2
 */
@Data
@Configuration
@ConfigurationProperties(prefix = RestControllerProperties.PREFIX)
public class RestControllerProperties {

    public static final String PREFIX = "lab.test.advice";

    /**
     * 是否启用@ControllerAdvice
     */
    public boolean enabled = true;

    public Set<String> excludePackages = new HashSet<>();

    public Set<String> excludeClasses = new HashSet<>();

    public Set<String> excludePaths = new HashSet<>();

}
