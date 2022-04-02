package cn.org.niubility.shutter.sdk.verifycode.exception;

import cn.org.niubility.shutter.core.common.exception.BaseException;

/**
 * 验证码过期或不存在的异常类。
 *
 * @author xuepeng
 */
public class VerifyCodeExpiredException extends BaseException {

    /**
     * 构造函数。
     */
    public VerifyCodeExpiredException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public VerifyCodeExpiredException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public VerifyCodeExpiredException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public VerifyCodeExpiredException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
