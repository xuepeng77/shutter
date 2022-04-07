package cn.org.shutter.sdk.redis.serializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * Redis的Json序列化类。
 *
 * @author xuepeng
 */
public class RedisJsonSerializer {

    /**
     * 构造函数。
     */
    private RedisJsonSerializer() {
    }

    /**
     * @return 创建一个基于Jackson的Redis序列化对象。
     */
    public static Jackson2JsonRedisSerializer<Object> serializer() {
        // 使用Jackson2JsonRedisSerializer来序列化和反序列化Redis的Value的值
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        final ObjectMapper objectMapper = new ObjectMapper();
        // 指定要序列化的域，Filed，Get和Set，以及修饰符范围ANY是，也包括Private和Public
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类等会抛出异常
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        return jackson2JsonRedisSerializer;
    }

}
