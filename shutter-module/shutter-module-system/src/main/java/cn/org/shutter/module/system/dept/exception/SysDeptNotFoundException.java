package cn.org.shutter.module.system.dept.exception;

import cn.org.shutter.core.common.exception.BaseException;

/**
 * 系统组织机构不存在的异常类。
 *
 * @author xuepeng
 */
public class SysDeptNotFoundException extends BaseException {

    /**
     * 构造函数。
     */
    public SysDeptNotFoundException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public SysDeptNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public SysDeptNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public SysDeptNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
