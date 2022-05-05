package cn.org.shutter.module.system.func.exception;

import cn.org.shutter.core.common.exception.BaseException;

/**
 * 系统功能不存在的异常类。
 *
 * @author xuepeng
 */
public class SysFuncNotFoundException extends BaseException {

    /**
     * 构造函数。
     */
    public SysFuncNotFoundException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public SysFuncNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public SysFuncNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public SysFuncNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
