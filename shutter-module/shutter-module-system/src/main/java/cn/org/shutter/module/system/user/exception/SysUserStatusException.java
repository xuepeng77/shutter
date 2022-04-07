package cn.org.shutter.module.system.user.exception;

import cn.org.shutter.core.common.exception.BaseException;

/**
 * 系统用户不可用的异常类。
 *
 * @author xuepeng
 */
public class SysUserStatusException extends BaseException {

    /**
     * 构造函数。
     */
    public SysUserStatusException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public SysUserStatusException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public SysUserStatusException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public SysUserStatusException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
