package cn.jaylong.axon;

import cn.hutool.extra.spring.SpringUtil;
import cn.jaylong.snowflake.Snowflake;
import org.axonframework.common.IdentifierFactory;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/11
 * Url: jaylong.cn
 */
public class SnowflakeIdentifierFactory extends IdentifierFactory {

    @Override
    public String generateIdentifier() {
        Snowflake snowflake = SpringUtil.getBean(Snowflake.class);
        return snowflake.nextIdStr();
    }
}
