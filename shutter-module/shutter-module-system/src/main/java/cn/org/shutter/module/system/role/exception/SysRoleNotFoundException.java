package cn.org.shutter.module.system.role.exception;

import cn.org.shutter.core.common.exception.BaseException;

/**
 * 系统角色不存在的异常类。
 *
 * @author xuepeng
 */
public class SysRoleNotFoundException extends BaseException {

    /**
     * 构造函数。
     */
    public SysRoleNotFoundException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public SysRoleNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public SysRoleNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public SysRoleNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
