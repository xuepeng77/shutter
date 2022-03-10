package cn.org.niubility.shutter.sdk.log4j2.config;

import cn.org.niubility.shutter.sdk.log4j2.interceptor.LogTrackInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoggerConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogTrackInterceptor()).addPathPatterns("/**");
    }

}
