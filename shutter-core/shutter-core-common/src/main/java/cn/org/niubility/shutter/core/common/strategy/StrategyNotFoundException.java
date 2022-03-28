package cn.org.niubility.shutter.core.common.strategy;

import cn.org.niubility.shutter.core.common.exception.BaseException;

/**
 * 系统用户不存在的异常类。
 *
 * @author xuepeng
 */
public class StrategyNotFoundException extends BaseException {

    /**
     * 构造函数。
     */
    public StrategyNotFoundException() {
    }

    /**
     * 构造函数。
     *
     * @param msg 异常信息。
     */
    public StrategyNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数。
     *
     * @param cause 异常原因。
     */
    public StrategyNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     *
     * @param msg   异常信息。
     * @param cause 异常原因。
     */
    public StrategyNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
