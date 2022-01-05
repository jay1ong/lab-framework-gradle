package cn.jaylong.web.springfox;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2022/1/5
 * Url: jaylong.cn
 */
@Data
@ConfigurationProperties(prefix = SpringfoxProperties.PREFIX)
public class SpringfoxProperties {

    public static final String PREFIX = "lab.springfox";

    /**
     * 是否启用swagger
     */
    public boolean enabled = true;

    /**
     * 是否启用swagger security
     */
    public boolean enableSecurity = false;

}
