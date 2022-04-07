package cn.org.shutter.core.common.strategy;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 * 策略工厂的父类。
 * 封装类获取策略实例的方法。
 *
 * @param <T> 策略的实现类。
 * @param <E> 策略类型枚举。
 * @author xuepeng
 */
@Slf4j
public abstract class BaseStrategyFactory<T extends BaseStrategy<E>, E> {

    /**
     * 根据策略类型查询策略实例。
     *
     * @param type 策略类型。
     * @return 策略实例。
     */
    public T getInstance(final E type) {
        // 根据类型查询策略
        final Optional<T> strategy = getStrategies().stream()
                .filter(s -> s.getType().equals(type))
                .findFirst();
        // 判断是否查询到策略，为查询到抛出NPE
        if (strategy.isPresent()) {
            return strategy.get();
        } else {
            log.error("无法从工厂中获取策[{}]类型的策略。", type);
            throw new StrategyNotFoundException("未匹配到指定的策略。");
        }
    }

    /**
     * @return 获取策略集合。
     */
    protected abstract List<T> getStrategies();

}
