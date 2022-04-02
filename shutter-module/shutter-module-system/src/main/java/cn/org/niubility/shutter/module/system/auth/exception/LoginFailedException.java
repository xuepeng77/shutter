package cn.org.niubility.shutter.module.system.auth.exception;

import cn.org.niubility.shutter.core.common.exception.BaseException;

/**
 * 登录系统失败的异常类。
 *
 * @author xuepeng
 */
public class LoginFailedException extends BaseException {

    /**
     * 构造函数。
     */
    public LoginFailedException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public LoginFailedException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public LoginFailedException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
