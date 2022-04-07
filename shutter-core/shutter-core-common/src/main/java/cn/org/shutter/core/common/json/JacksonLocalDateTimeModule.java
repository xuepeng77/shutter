package cn.org.shutter.core.common.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Java8的时间类型序列化。
 *
 * @author xuepeng
 */
public enum JacksonLocalDateTimeModule {

    /**
     * Java8的时间类型序列化枚举。
     */
    INSTANCE;

    /**
     * Java时间序列化配置模块。
     */
    private final JavaTimeModule javaTimeModule;

    /**
     * 创建一个Java时间序列化配置模块。
     */
    JacksonLocalDateTimeModule() {
        javaTimeModule = new JavaTimeModule();
        // 获取系统默认时区
        final ZoneOffset zoneOffset = OffsetDateTime.now().getOffset();
        // LocalDateTime类型序列化成时间戳（毫秒数）。
        javaTimeModule.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public void serialize(LocalDateTime localDateTime,
                                  JsonGenerator jsonGenerator,
                                  SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeNumber(localDateTime.toInstant(zoneOffset).toEpochMilli());
            }
        });
        // 时间戳（秒数）序列化成LocalDateTime。
        javaTimeModule.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                final long timestamp = jsonParser.getLongValue();
                return LocalDateTime.ofEpochSecond(timestamp / 1000, 0, zoneOffset);
            }
        });
    }

    /**
     * @return 获取单例的Java时间序列化配置模块。
     */
    public JavaTimeModule getInstance() {
        return this.javaTimeModule;
    }

}
