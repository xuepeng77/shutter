package cn.org.niubility.shutter.module.system.user.dto;

import cn.org.niubility.shutter.core.common.bean.dto.BaseDto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 系统用户的数据传输类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysUserDto extends BaseDto {

    /**
     * 帐号。
     */
    private String account;

    /**
     * 密码。
     */
    private String password;

    /**
     * 手机号。
     */
    private String phoneNumber;

    /**
     * 邮箱。
     */
    private String email;

    /**
     * 中文名。
     */
    private String chineseName;

    /**
     * 英文名。
     */
    private String englishName;

    /**
     * 昵称。
     */
    private String nickName;

    /**
     * 生日。
     */
    private LocalDate birthday;

    /**
     * 性别。
     */
    private Integer gender;

    /**
     * 头像。
     */
    private String avatar;

    /**
     * 状态：0=禁用；1=启用。
     */
    private Integer status;

    /**
     * 注册IP。
     */
    private String regeditIp;

    /**
     * 登录IP。
     */
    private String loginIp;

    /**
     * 登录时间。
     */
    private LocalDateTime loginTime;

}
