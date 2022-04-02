package cn.org.niubility.shutter.sdk.verifycode.config;

import cn.org.niubility.shutter.sdk.verifycode.property.VerifyCodeProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码的配置类。
 * 提供图片验证码、短信验证码和邮件验证码的业务功能。
 *
 * @author xuepeng
 */
@Configuration
@EnableConfigurationProperties(VerifyCodeProperty.class)
public class VerifyCodeConfiguration {
}
