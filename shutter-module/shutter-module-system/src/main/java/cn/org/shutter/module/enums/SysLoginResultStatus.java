package cn.org.shutter.module.enums;

import cn.org.shutter.core.common.api.ResultStatus;

/**
 * 系统登录的响应状态类。
 *
 * @author xuepeng
 */
public enum SysLoginResultStatus implements ResultStatus {

    /**
     * 登录失败。
     */
    LOGIN_FAILED(50001, "登录失败。"),

    /**
     * 验证码已过期。
     */
    VERIFY_CODE_EXPIRED(50002, "验证码已过期。"),

    /**
     * 验证码不正确
     */
    VERIFY_CODE_INCORRECT(50003, "验证码不正确。");

    /**
     * 构造函数。
     *
     * @param code 状态编码。
     * @param desc 状态描述。
     */
    SysLoginResultStatus(
            final int code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * @return 获得状态编码。
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * @return 获得状态描述。
     */
    @Override
    public String getDesc() {
        return desc;
    }

    /**
     * 状态编码。
     */
    private final int code;

    /**
     * 状态描述。
     */
    private final String desc;

}
