package cn.org.shutter.module.property;

import cn.org.shutter.module.system.user.service.password.PasswordStrategyType;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 系统管理的自定义属性类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
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
