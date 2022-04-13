package cn.org.shutter.sdk.satoken.service;

import lombok.*;

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

}
