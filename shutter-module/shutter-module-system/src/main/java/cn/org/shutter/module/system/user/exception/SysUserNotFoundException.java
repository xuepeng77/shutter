package cn.org.shutter.module.system.user.exception;

import cn.org.shutter.core.common.exception.BaseException;

/**
 * 系统用户不存在的异常类。
 *
 * @author xuepeng
 */
public class SysUserNotFoundException extends BaseException {

    /**
     * 构造函数。
     */
    public SysUserNotFoundException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public SysUserNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public SysUserNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public SysUserNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
