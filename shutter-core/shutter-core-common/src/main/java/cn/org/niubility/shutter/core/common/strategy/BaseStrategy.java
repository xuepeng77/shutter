package cn.org.niubility.shutter.core.common.strategy;

/**
 * 策略模式的父接口。
 * 声明了策略工厂创建策略时类型。
 *
 * @param <E> 策略类型，通常是枚举。
 * @author xuepeng
 */
public interface BaseStrategy<E> {

    /**
     * @return 获取策略类型。
     */
    E getType();

}
