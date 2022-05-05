package cn.org.shutter.core.web.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 当前登录人。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUser {

    /**
     * 主键。
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 帐号。
     */
    @ApiModelProperty(value = "帐号")
    private String account;

    /**
     * 手机号。
     */
    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    /**
     * 邮箱。
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 中文名。
     */
    @ApiModelProperty(value = "中文名")
    private String chineseName;

    /**
     * 英文名。
     */
    @ApiModelProperty(value = "英文名")
    private String englishName;

    /**
     * 昵称。
     */
    @ApiModelProperty(value = "昵称")
    private String nickName;

    /**
     * 生日。
     */
    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    /**
     * 性别。
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;

    /**
     * 头像。
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 注册IP。
     */
    @ApiModelProperty(value = "注册IP")
    private String regeditIp;

    /**
     * 登录IP。
     */
    @ApiModelProperty(value = "登录IP")
    private String loginIp;

    /**
     * 登录时间。
     */
    @ApiModelProperty(value = "登录时间")
    private LocalDateTime loginTime;

    /**
     * 角色。
     */
    @ApiModelProperty(value = "角色")
    private List<CurrentUserRole> roles;

    /**
     * 功能。
     */
    @ApiModelProperty(value = "功能")
    private List<CurrentUserFunc> funcs;

}
