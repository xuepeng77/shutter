package cn.org.shutter.module.system.user.service.password;

import cn.org.shutter.core.common.strategy.BaseStrategy;

/**
 * 登录密码策略的接口。
 *
 * @author xuepeng
 */
public interface PasswordStrategy extends BaseStrategy<PasswordStrategyType> {

    /**
     * 生成登录密码。
     *
     * @return 登录密码。
     */
    String generate();

    /**
     * 验证登录密码是否正确。
     *
     * @param password 本次登录的密码。
     * @param hash     数据库中的密码。
     * @return 登录密码是否正确。
     */
    boolean verify(String password, String hash);

}
