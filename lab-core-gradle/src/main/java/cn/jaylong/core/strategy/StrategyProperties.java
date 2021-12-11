package cn.jaylong.core.strategy;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/2
 */
@Data
@ConfigurationProperties(prefix = StrategyProperties.PREFIX)
public class StrategyProperties {

    public static final String PREFIX = "lab.core.strategy";

    /**
     * 是否启用 Strategy
     */
    public boolean enabled = true;

}
