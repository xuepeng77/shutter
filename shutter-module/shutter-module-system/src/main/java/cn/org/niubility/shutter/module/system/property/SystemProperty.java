package cn.org.niubility.shutter.module.system.property;

import cn.org.niubility.shutter.module.system.user.service.password.PasswordStrategyType;
import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 系统管理的自定义配置类。
 *
 * @author xuepeng
 */
@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "shutter.module.system")
public class SystemProperty {

    /**
     * 系统用户的自定义配置类。
     */
    private SysUserProperty sysUserProperty;

    /**
     * 系统用户的自定义配置类。
     *
     * @author xuepeng
     */
    @Data
    @ToString
    public static class SysUserProperty {

        /**
         * 随机密码的长度。
         */
        private Integer randomPasswordLength = 8;

        /**
         * 登录密码的策略类型。
         */
        private PasswordStrategyType passwordStrategyType = PasswordStrategyType.BCRYPT;

    }

}
