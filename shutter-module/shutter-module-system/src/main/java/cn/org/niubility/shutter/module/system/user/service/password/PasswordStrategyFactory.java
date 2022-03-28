package cn.org.niubility.shutter.module.system.user.service.password;

import cn.org.niubility.shutter.core.common.strategy.BaseStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统用户登录密码策略的工厂类。
 *
 * @author xuepeng
 */
@Component
@Slf4j
public final class PasswordStrategyFactory extends BaseStrategyFactory<PasswordStrategy, PasswordStrategyType> {

    /**
     * @return 获取策略集合。
     */
    @Override
    protected List<PasswordStrategy> getStrategies() {
        return this.strategies;
    }

    /**
     * 自动装配策略集合。
     *
     * @param strategies 策略集合。
     */
    @Autowired
    public void setStrategies(List<PasswordStrategy> strategies) {
        this.strategies = strategies;
    }

    /**
     * 策略集合。
     */
    private List<PasswordStrategy> strategies;

}
