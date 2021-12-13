package cn.jaylong.autoconfig.snowflake;

import cn.jaylong.snowflake.SnowFlakeProperties;
import cn.jaylong.snowflake.Snowflake;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/11
 * Url: jaylong.cn
 */
@Configuration
@EnableConfigurationProperties(SnowFlakeProperties.class)
@ConditionalOnClass({Snowflake.class})
@AllArgsConstructor
public class SnowflakeAutoConfiguration {

    private final SnowFlakeProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public Snowflake snowflake() {
        return new Snowflake(properties);
    }

}
