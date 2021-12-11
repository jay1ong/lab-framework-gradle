package cn.jaylong.autoconfig.core;

import cn.jaylong.core.strategy.StrategyProperties;
import cn.jaylong.core.strategy.StrategyService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/11
 * Url: jaylong.cn
 */
@Configuration
@EnableConfigurationProperties(StrategyProperties.class)
@ConditionalOnClass(StrategyService.class)
@AllArgsConstructor
public class StrategyAutoConfiguration {

    private final StrategyProperties properties;

    private final ApplicationContext context;

    @Bean
    @ConditionalOnMissingBean
    public StrategyService service() {
        if (properties.enabled) {
            return new StrategyService(context);
        }
        return null;
    }

}
