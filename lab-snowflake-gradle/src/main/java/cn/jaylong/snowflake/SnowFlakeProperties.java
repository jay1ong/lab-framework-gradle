package cn.jaylong.snowflake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/2
 */
@ConfigurationProperties(prefix = SnowFlakeProperties.PREFIX)
public class SnowFlakeProperties {

    public static final String PREFIX = "lab.snowflake";

    private static final long WORKER_ID_BITS = 5L;

    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

    private static final long DATA_CENTER_ID_BITS = 5L;

    private static final long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_ID_BITS);

    public Date epochDate = new Date(1288834974657L);

    public long workerId = IdUtil.getWorkerId(IdUtil.getDataCenterId(MAX_DATA_CENTER_ID), MAX_WORKER_ID);

    public long dataCenterId = IdUtil.getDataCenterId(MAX_DATA_CENTER_ID);

    public boolean useSystemClock = false;

    public long timeOffset = Snowflake.DEFAULT_TIME_OFFSET;
}
