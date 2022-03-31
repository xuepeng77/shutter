package cn.org.niubility.shutter.core.web.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Spring MVC的Jackson序列化配置。
 *
 * @author xuepeng
 */
@Configuration
public class Jackson2HttpMessageConverter {

    /**
     * 日期格式化表达式。
     */
    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
    private String pattern;

    /**
     * @return 创建一个自定义的Json序列化对象。
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> {
            builder.serializerByType(
                    LocalDateTime.class,
                    new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern))
            );
            builder.deserializerByType(
                    LocalDateTime.class,
                    new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(pattern))
            );
            builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        };
    }

}
