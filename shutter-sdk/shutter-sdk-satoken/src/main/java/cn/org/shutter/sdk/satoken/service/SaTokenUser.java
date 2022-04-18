package cn.org.shutter.sdk.satoken.service;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * SaToken用户的实体类。
 * 表示当前登录人。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SaTokenUser {

    /**
     * 主键。
     */
    private Long id;

    /**
     * 帐号。
     */
    private String account;

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
