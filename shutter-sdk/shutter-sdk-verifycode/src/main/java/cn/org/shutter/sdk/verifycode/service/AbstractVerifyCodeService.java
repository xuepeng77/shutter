package cn.org.shutter.sdk.verifycode.service;

import cn.org.shutter.sdk.verifycode.entity.VerifyCode;
import cn.org.shutter.sdk.verifycode.property.VerifyCodeProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 验证码的业务处理抽象类。
 *
 * @author xuepeng
 */
public abstract class AbstractVerifyCodeService implements VerifyCodeService {

    /**
     * 发送验证码。
     *
     * @param to 发送目标。
     * @return 验证码。
     */
    @Override
    public VerifyCode send(final String to) {
        before(to);
        final VerifyCode verifyCode = sending(to);
        after(verifyCode);
        return verifyCode;
    }

    /**
     * 发送前的处理。
     *
     * @param to 发送目标。
     */
    protected abstract void before(final String to);

    /**
     * 发送验证码。
     *
     * @param to 发送目标。
     * @return 验证码。
     */
    protected abstract VerifyCode sending(final String to);

    /**
     * 发送后的处理。
     *
     * @param verifyCode 验证码。
     */
    protected abstract void after(final VerifyCode verifyCode);

    /**
     * 自动装配验证码的配置对象。
     *
     * @param verifyCodeProperty 验证码的配置对象。
     */
    @Autowired
    public void setVerifyCodeProperty(VerifyCodeProperty verifyCodeProperty) {
        this.verifyCodeProperty = verifyCodeProperty;
    }

    /**
     * 自动装配Redis工具类。
     *
     * @param redisTemplate Redis工具类。
     */
    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 验证码的配置对象。
     */
    protected VerifyCodeProperty verifyCodeProperty;

    /**
     * Redis工具类。
     */
    protected RedisTemplate<String, Object> redisTemplate;

}
