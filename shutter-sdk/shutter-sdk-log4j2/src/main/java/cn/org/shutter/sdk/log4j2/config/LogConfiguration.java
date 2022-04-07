package cn.org.shutter.sdk.log4j2.config;

import cn.org.shutter.sdk.log4j2.interceptor.LogTrackInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Log4j2的配置类。
 * 提供日志级别的热转换，提供日志追踪功能。
 *
 * @author xuepeng
 */
@Configuration
public class LogConfiguration implements WebMvcConfigurer {

    // TODO 加入异步日志功能

    /**
     * 注册日志拦截器。
     * 对所有API(/**)生效。
     *
     * @param registry 拦截器注册表。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogTrackInterceptor()).addPathPatterns("/**");
    }

}
