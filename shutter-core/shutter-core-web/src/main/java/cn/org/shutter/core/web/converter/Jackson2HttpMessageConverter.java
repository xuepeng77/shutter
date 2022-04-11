package cn.org.shutter.core.web.converter;

import cn.org.shutter.core.common.consts.DateTimeConst;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Spring MVC的Jackson序列化配置。
 *
 * @author xuepeng
 */
public class Jackson2HttpMessageConverter {

    /**
     * @return 自定义Jackson序列化处理ajax请求中的LocalDateTime类型。
     */
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return builder -> {
            builder.serializerByType(
                    LocalDateTime.class,
                    new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DateTimeConst.YYYY_MM_DD_HH_MM_SS))
            );
            builder.deserializerByType(
                    LocalDateTime.class,
                    new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DateTimeConst.YYYY_MM_DD_HH_MM_SS))
            );
        };
    }

}
