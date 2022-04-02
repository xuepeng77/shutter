package cn.org.niubility.shutter.module.enums;

import cn.org.niubility.shutter.core.common.bean.api.ResultStatus;

/**
 * 系统登录的响应状态类。
 *
 * @author xuepeng
 */
public enum VerifyCodeResultStatus implements ResultStatus {

    /**
     * 验证码已过期。
     */
    EXPIRED(50101, "验证码已过期。"),

    /**
     * 验证码不正确
     */
    INCORRECT(50102, "验证码不正确。");

    /**
     * 构造函数。
     *
     * @param code 状态编码。
     * @param desc 状态描述。
     */
    VerifyCodeResultStatus(
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
