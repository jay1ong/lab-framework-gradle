package cn.jaylong.axon;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/2
 */
@Data
@ConfigurationProperties(prefix = SnowflakeIdentifierProperties.PREFIX)
public class SnowflakeIdentifierProperties {

    public static final String PREFIX = "lab.axon.snowflake-identifier";

    /**
     * 是否启用@ControllerAdvice
     */
    public boolean enabled = true;

}
