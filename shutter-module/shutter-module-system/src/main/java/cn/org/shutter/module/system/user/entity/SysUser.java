package cn.org.shutter.module.system.user.entity;

import cn.org.shutter.module.system.user.enums.SysUserStatus;
import cn.org.shutter.sdk.mybatis.entity.BizEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 系统用户实体类。
 * 数据库表：sys_user，系统用户表。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysUser extends BizEntity {

    /**
     * 帐号。
     * 数据库字段：account，varchar(32)。
     */
    private String account;

    /**
     * 密码。
     * 数据库字段：password，varchar(60)。
     */
    private String password;

    /**
     * 手机号。
     * 数据库字段：phone_number，varchar(32)。
     */
    private String phoneNumber;

    /**
     * 邮箱。
     * 数据库字段：email，varchar(128)。
     */
    private String email;

    /**
     * 中文名。
     * 数据库字段：chinese_name，varchar(8)。
     */
    private String chineseName;

    /**
     * 英文名。
     * 数据库字段：english_name，varchar(64)。
     */
    private String englishName;

    /**
     * 昵称。
     * 数据库字段：nick_name，varchar(32)。
     */
    private String nickName;

    /**
     * 生日。
     * 数据库字段：birthday，date。
     */
    private LocalDate birthday;

    /**
     * 性别。
     * 数据库字段：gender，tinyint(2)。
     */
    private Integer gender;

    /**
     * 头像。
     * 数据库字段：avatar，varchar(256)。
     */
    private String avatar;

    /**
     * 状态：0=禁用；1=启用。
     * 数据库字段：status，tinyint(2)。
     */
    private SysUserStatus status;

    /**
     * 注册IP。
     * 数据库字段：regedit_ip，varchar(32)。
     */
    private String regeditIp;

    /**
     * 登录IP。
     * 数据库字段：login_ip，varchar(32)。
     */
    private String loginIp;

    /**
     * 登录时间。
     * 数据库字段：login_time，timestamp。
     */
    private LocalDateTime loginTime;

}
