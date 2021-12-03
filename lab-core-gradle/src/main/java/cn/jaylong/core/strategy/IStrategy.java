package cn.jaylong.core.strategy;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/11/12
 */
public interface IStrategy<T> {

    boolean match(T param);

}
