package cn.org.niubility.shutter.module.system.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 系统管理的配置类。
 *
 * @author xuepeng
 */
@Configuration
@EnableConfigurationProperties(SystemProperty.class)
public class SystemConfiguration {

}
