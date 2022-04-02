package cn.org.niubility.shutter.module.system.auth.exception;

import cn.org.niubility.shutter.core.common.exception.BaseException;

/**
 * 验证码不正确的异常类。
 *
 * @author xuepeng
 */
public class VerifyCodeIncorrectException extends BaseException {

    /**
     * 构造函数。
     */
    public VerifyCodeIncorrectException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public VerifyCodeIncorrectException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public VerifyCodeIncorrectException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public VerifyCodeIncorrectException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
