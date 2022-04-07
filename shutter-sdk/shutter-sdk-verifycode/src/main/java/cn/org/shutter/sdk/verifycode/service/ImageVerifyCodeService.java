package cn.org.shutter.sdk.verifycode.service;

import cn.org.shutter.core.common.util.RandomUtil;
import cn.org.shutter.sdk.verifycode.entity.VerifyCode;
import cn.org.shutter.sdk.verifycode.exception.VerifyCodeExpiredException;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 图形验证码的业务处理实现类。
 *
 * @author xuepeng
 */
@Component("imageVerifyCodeService")
@Slf4j
public class ImageVerifyCodeService extends AbstractVerifyCodeService {

    /**
     * 图形验证码RedisKey。
     */
    private static final String KEY_PROFIX = "SHUTTER:LOGIN:VERIFYCODE:";

    /**
     * 发送前的处理。
     * 图形验证码在发送前无须处理。
     *
     * @param to 发送目标。
     */
    @Override
    protected void before(final String to) {
        // nothing
    }

    /**
     * 发送验证码。
     *
     * @param to 发送目标。
     * @return 验证码。
     */
    @Override
    protected VerifyCode sending(final String to) {
        final Captcha captcha = new ArithmeticCaptcha(
                verifyCodeProperty.getImage().getCaptchaImgWidth(),
                verifyCodeProperty.getImage().getCaptchaImgHeight()
        );
        captcha.setLen(verifyCodeProperty.getImage().getCaptchaLength());
        final String uuid = RandomUtil.get32UUID();
        final String img = captcha.toBase64();
        final String text = captcha.text();
        if (log.isDebugEnabled()) {
            log.debug("创建验证码成功，uuid：{}，text：{}，img：{}", uuid, text, img);
        }
        return VerifyCode.builder().uuid(uuid).img(img).code(text).build();
    }

    /**
     * 发送后的处理。
     * 保存生成的验证码。
     *
     * @param verifyCode 验证码。
     */
    @Override
    protected void after(final VerifyCode verifyCode) {
        final String key = KEY_PROFIX + verifyCode.getUuid();
        redisTemplate.opsForValue().set(
                key,
                verifyCode.getCode(),
                verifyCodeProperty.getImage().getExpiration()
        );
        verifyCode.setCode(StringUtils.EMPTY);
    }

    /**
     * 校验验证码是否正确。
     *
     * @param verifyCode 验证码。
     * @return 是否正确。
     */
    @Override
    public boolean validate(final VerifyCode verifyCode) {
        final String key = KEY_PROFIX + verifyCode.getUuid();
        final String code = verifyCode.getCode();
        final String answer = (String) redisTemplate.opsForValue().get(key);
        // 删除验证码，验证码进行一次校验，无论对错都会删除
        redisTemplate.delete(key);
        // 判断验证码是否正确
        if (log.isDebugEnabled()) {
            log.debug("判断验证码是否正确, 生成的验证码：{}, 输入的验证码：{}", code, answer);
        }
        if (StringUtils.isBlank(answer)) {
            throw new VerifyCodeExpiredException("验证码不存在或过期");
        }
        return StringUtils.isNotBlank(code) && StringUtils.equals(answer, code);
    }

}
