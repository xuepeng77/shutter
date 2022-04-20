package cn.org.shutter.module.system.func.enums;

import cn.org.shutter.core.common.bean.enums.BaseEnum;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 系统菜单的类型枚举。
 *
 * @author xuepeng
 */
@Getter
@AllArgsConstructor
@ToString
public enum SysFuncType implements BaseEnum {

    ENUM(0, "菜单"),

    BUTTON(1, "按钮");

    /**
     * 查找枚举。
     * JsonCreator注解代表Jackson反序列化时使用该方法查找枚举。
     *
     * @param code 枚举值。
     * @return 枚举。
     */
    @JsonCreator
    public static SysFuncType findEnum(final Integer code) {
        for (SysFuncType e : values()) {
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
