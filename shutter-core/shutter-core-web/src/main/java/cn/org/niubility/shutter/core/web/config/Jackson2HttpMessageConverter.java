package cn.org.niubility.shutter.core.web.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring MVC的Jackson序列化配置。
 *
 * @author xuepeng
 */
@Configuration
public class Jackson2HttpMessageConverter {

    /**
     * @return 创建一个自定义的Json序列化对象。
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        // 无其他设置时，序列化枚举时调用枚举的toString方法
        return builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    }

}
