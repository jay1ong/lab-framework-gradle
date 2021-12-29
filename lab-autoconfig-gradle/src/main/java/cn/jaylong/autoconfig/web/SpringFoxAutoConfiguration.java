package cn.jaylong.autoconfig.web;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/12
 * Url: jaylong.cn
 */
@Configuration
@ConditionalOnWebApplication
@AllArgsConstructor
public class SpringFoxAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                //不显示错误的接口地址
                //错误路径不监控
                .paths(PathSelectors.regex("/error.*").negate())
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

}
