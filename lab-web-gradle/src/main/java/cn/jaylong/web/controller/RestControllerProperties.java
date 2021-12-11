package cn.jaylong.web.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/2
 */
@Data
@ConfigurationProperties(prefix = RestControllerProperties.PREFIX)
public class RestControllerProperties {

    public static final String PREFIX = "lab.web.advice";

    /**
     * 是否启用@ControllerAdvice
     */
    public boolean enabled = true;

    public Set<String> excludePackages = new HashSet<>();

    public Set<String> excludeClasses = new HashSet<>();

    public Set<String> excludePaths = new HashSet<>();

}
