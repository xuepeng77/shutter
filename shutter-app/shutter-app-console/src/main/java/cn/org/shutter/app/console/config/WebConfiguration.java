package cn.org.shutter.app.console.config;

import cn.org.shutter.core.web.converter.EnumConverterFactory;
import cn.org.shutter.core.web.converter.Jackson2HttpMessageConverter;
import cn.org.shutter.core.web.converter.LocalDateTimeConverter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web应用配置类。
 * 1、配置请求参数的枚举转换器、日志转换器，处理Url参数中的数据；
 * 2、配置请求体的枚举转换器，处理Ajax的Body中的数据；
 *
 * @author xuepeng
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 注册Spring MVC的自定义转换器。
     *
     * @param registry 转换器注册器。
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateTimeConverter());
        registry.addConverterFactory(new EnumConverterFactory());
    }

    /**
     * @return 配置Jackson序列化，处理ajax请求中的LocalDateTime类型。
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return new Jackson2HttpMessageConverter().customizer();
    }

}
