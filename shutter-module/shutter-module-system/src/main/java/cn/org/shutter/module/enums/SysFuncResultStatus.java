package cn.org.shutter.module.enums;

import cn.org.shutter.core.common.api.ResultStatus;

/**
 * 系统功能的响应状态类。
 *
 * @author xuepeng
 */
public enum SysFuncResultStatus implements ResultStatus {

    /**
     * 功能不存在。
     */
    NOT_FOUND(50301, "功能不存在。");

    /**
     * 构造函数。
     *
     * @param code 状态编码。
     * @param desc 状态描述。
     */
    SysFuncResultStatus(
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
