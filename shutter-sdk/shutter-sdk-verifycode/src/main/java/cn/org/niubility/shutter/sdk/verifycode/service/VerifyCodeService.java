package cn.org.niubility.shutter.sdk.verifycode.service;

import cn.org.niubility.shutter.sdk.verifycode.entity.VerifyCode;

/**
 * 验证码的业务处理接口。
 *
 * @author xuepeng
 */
public interface VerifyCodeService {

    /**
     * 发送验证码。
     *
     * @param to 发送目标。
     * @return 验证码。
     */
    VerifyCode send(final String to);

    /**
     * 校验验证码是否正确。
     *
     * @param verifyCode 验证码。
     * @return 是否正确。
     */
    boolean validate(final VerifyCode verifyCode);

}
