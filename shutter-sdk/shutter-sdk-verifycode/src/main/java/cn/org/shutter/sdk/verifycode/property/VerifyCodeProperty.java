package cn.org.shutter.sdk.verifycode.property;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * 验证码的自定义属性类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "shutter.verify-code")
public class VerifyCodeProperty {

    /**
     * 图片验证码的配置对象。
     */
    private ImageVerifyCodeConfiguration image = new ImageVerifyCodeConfiguration();

    /**
     * 短信验证码的配置对象。
     */
    private SmsVerifyCodeConfiguration sms = new SmsVerifyCodeConfiguration();

    /**
     * 邮件验证码的配置对象。
     */
    private EmailVerifyCodeConfiguration email = new EmailVerifyCodeConfiguration();

    /**
     * 图片验证码的自定义属性类。
     *
     * @author xuepeng
     */
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageVerifyCodeConfiguration {

        /**
         * 缓存过期时间
         */
        private Duration expiration = Duration.ofMinutes(2);

        /**
         * 图片宽度
         */
        private Integer captchaImgWidth = 127;

        /**
         * 图片高度
         */
        private Integer captchaImgHeight = 40;

        /**
         * 验证码长度。
         */
        private Integer captchaLength = 2;

    }

    /**
     * 短信验证码的自定义属性类。
     *
     * @author xuepeng
     */
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SmsVerifyCodeConfiguration {

        /**
         * 验证码的过期时间
         */
        private Duration verifyCodeExpiration = Duration.ofMinutes(10L);

        /**
         * 验证码发送的间隔时间
         */
        private Duration verifyCodeRateExpiration = Duration.ofMinutes(2L);

        /**
         * 每个手机号当天发送验证码的最大次数。
         */
        private Integer verifyCodeSendMaxCount = 10;

    }

    /**
     * 邮件验证码的自定义属性类。
     *
     * @author xuepeng
     */
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmailVerifyCodeConfiguration {

        /**
         * 验证码的过期时间
         */
        private Duration verifyCodeExpiration = Duration.ofMinutes(10L);

    }

}
