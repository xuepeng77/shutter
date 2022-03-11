package cn.org.niubility.shutter.sdk.redis.config;

import cn.org.niubility.shutter.sdk.redis.serializer.RedisJsonSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * Redis的配置类。
 * 对RedisTemplate进行了序列化设置。
 * Redis中的Key和HashKey采用String序列化。
 * Redis中的Value和HashValue采用Json（Jackson）序列化。
 *
 * @author xuepeng
 */
@Configuration
public class RedisConfiguration {

    // TODO 加入分布式锁、SpringCache等功能

    /**
     * 创建一个RedisTemplate对象。
     *
     * @return RedisTemplate对象。
     */
    @Bean(name = "redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 配置连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // RedisKey使用String进行序列化
        final StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // RedisValue使用Json进行序列化
        final Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = RedisJsonSerializer.serializer();
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);
        // 后置处理
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * Redis连接工厂。
     */
    @Resource
    private LettuceConnectionFactory redisConnectionFactory;

}
