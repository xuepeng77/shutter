package cn.org.niubility.shutter.module.system.login.dto;

import lombok.*;

/**
 * 系统登录的数据传输类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SysLoginDto {

    /**
     * 帐号。
     */
    private String account;

    /**
     * 密码。
     */
    private String password;

    /**
     * 验证码编号。
     */
    private String uuid;

    /**
     * 验证码。
     */
    private String code;

    /**
     * 登录IP地址。
     */
    private String ip;

}
