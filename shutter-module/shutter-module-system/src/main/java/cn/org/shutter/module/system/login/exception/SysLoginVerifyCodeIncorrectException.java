package cn.org.shutter.module.system.login.exception;

import cn.org.shutter.core.common.exception.BaseException;

/**
 * 验证码不正确的异常类。
 *
 * @author xuepeng
 */
public class SysLoginVerifyCodeIncorrectException extends BaseException {

    /**
     * 构造函数。
     */
    public SysLoginVerifyCodeIncorrectException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public SysLoginVerifyCodeIncorrectException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public SysLoginVerifyCodeIncorrectException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public SysLoginVerifyCodeIncorrectException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
