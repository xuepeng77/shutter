package cn.org.niubility.shutter.module.system.user.service.password;

import cn.hutool.crypto.digest.BCrypt;
import cn.org.niubility.shutter.core.common.util.RandomUtil;
import cn.org.niubility.shutter.module.property.SystemProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 基于BCrypt算法的登录密码策略的实现类。
 *
 * @author xuepeng
 */
@Component
@Slf4j
public class BCryptPasswordStrategy extends AbstractPasswordStrategy {

    /**
     * 生成随机的登录密码。
     *
     * @return 登录密码。
     */
    @Override
    public String random() {
        // 生成默认的登录密码。
        return RandomUtil.getRandomString(systemProperty.getSysUserProperty().getRandomPasswordLength());
    }

    /**
     * 使用算法对密码进行加密。
     *
     * @param password 对密码进行加密。
     * @return 登录密码。
     */
    @Override
    public String encode(final String password) {
        // 使用BCrypt对密码进行加密，采用默认的10位盐
        return BCrypt.hashpw(password);
    }

    /**
     * 验证登录密码是否正确。
     *
     * @param password 本次登录的密码。
     * @param hash     数据库中的密码。
     * @return 登录密码是否正确。
     */
    @Override
    public boolean verify(final String password, final String hash) {
        return BCrypt.checkpw(password, hash);
    }

    /**
     * @return 获取策略类型。
     */
    @Override
    public PasswordStrategyType getType() {
        return PasswordStrategyType.BCRYPT;
    }

    /**
     * 自动装配系统管理的自定义配置类。
     *
     * @param systemProperty 系统管理的自定义配置类。
     */
    @Autowired
    public void setSystemProperty(SystemProperty systemProperty) {
        this.systemProperty = systemProperty;
    }

    /**
     * 系统管理的自定义配置类。
     */
    private SystemProperty systemProperty;

}
