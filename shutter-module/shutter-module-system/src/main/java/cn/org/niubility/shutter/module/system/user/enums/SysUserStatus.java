package cn.org.niubility.shutter.module.system.user.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 系统用户状态枚举。
 *
 * @author xuepeng
 */
@Getter
@AllArgsConstructor
@ToString
public enum SysUserStatus {

    ENABLE(1, "启用"),

    DISABLE(0, "禁用");

    /**
     * 查找枚举。
     * JsonCreator注解代表Jackson反序列化时使用该方法查找枚举。
     *
     * @param code 枚举值。
     * @return 枚举。
     */
    @JsonCreator
    public static SysUserStatus findEnum(final Integer code) {
        for (SysUserStatus e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 枚举值。
     * JsonValue注解代表序列化时使用的值。
     * EnumValue注解代表写入数据库的值。
     */
    @JsonValue
    @EnumValue
    private final Integer code;

    /**
     * 枚举描述。
     */
    private final String desc;

}
