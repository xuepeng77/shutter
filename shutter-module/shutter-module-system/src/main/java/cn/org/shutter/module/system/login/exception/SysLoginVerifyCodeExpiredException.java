package cn.org.shutter.module.system.login.exception;

import cn.org.shutter.core.common.exception.BaseException;

/**
 * 登录验证码已过期的异常类。
 *
 * @author xuepeng
 */
public class SysLoginVerifyCodeExpiredException extends BaseException {

    /**
     * 构造函数。
     */
    public SysLoginVerifyCodeExpiredException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public SysLoginVerifyCodeExpiredException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public SysLoginVerifyCodeExpiredException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public SysLoginVerifyCodeExpiredException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
