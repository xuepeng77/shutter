package cn.org.shutter.module.config;

import cn.org.shutter.module.property.SystemProperty;
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
