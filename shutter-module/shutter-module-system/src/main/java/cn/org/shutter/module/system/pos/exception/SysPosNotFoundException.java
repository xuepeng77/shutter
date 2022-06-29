package cn.org.shutter.module.system.pos.exception;

import cn.org.shutter.core.common.exception.BaseException;

/**
 * 系统岗位不存在的异常类。
 *
 * @author xuepeng
 */
public class SysPosNotFoundException extends BaseException {

    /**
     * 构造函数。
     */
    public SysPosNotFoundException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public SysPosNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public SysPosNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public SysPosNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
