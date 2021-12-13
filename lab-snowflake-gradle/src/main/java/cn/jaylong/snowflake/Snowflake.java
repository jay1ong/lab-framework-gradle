package cn.jaylong.snowflake;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/12/12
 * Url: jaylong.cn
 */
public class Snowflake {

    private final cn.hutool.core.lang.Snowflake snowflake;

    public Snowflake(SnowFlakeProperties properties) {
        this.snowflake = new cn.hutool.core.lang.Snowflake(
                properties.epochDate,
                properties.workerId,
                properties.dataCenterId,
                properties.useSystemClock,
                properties.timeOffset);
    }

    public long getWorkerId(long id) {
        return snowflake.getWorkerId(id);
    }

    public long getDataCenterId(long id) {
        return snowflake.getDataCenterId(id);
    }

    public long getGenerateDateTime(long id) {
        return snowflake.getGenerateDateTime(id);
    }

    public synchronized long nextId() {
        return snowflake.nextId();
    }

    public String nextIdStr() {
        return snowflake.nextIdStr();
    }
}
