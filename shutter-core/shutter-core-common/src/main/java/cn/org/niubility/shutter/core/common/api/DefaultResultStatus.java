package cn.org.niubility.shutter.core.common.api;

/**
 * 提供的默认Result对象。
 * 包括成功、超时、参数错误、操作失败、授权失败、系统异常等错误。
 *
 * @author xuepeng
 */
public enum DefaultResultStatus implements ResultStatus {

    /**
     * 成功。
     */
    SUCCESS(20000, "成功"),
    /**
     * 超时。
     */
    TIMEOUT(30000, "超时"),
    /**
     * 参数非法。
     */
    PARAM(40000, "参数错误"),
    /**
     * 失败。
     */
    FAIL(50000, "操作失败"),
    /**
     * 授权失败。
     */
    PERMISSIONS(60000, "授权失败"),
    /**
     * 系统异常。
     */
    ERROR(90000, "系统异常");

    /**
     * 构造函数。
     *
     * @param code 状态编码。
     * @param desc 状态描述。
     */
    DefaultResultStatus(final int code, final String desc) {
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
