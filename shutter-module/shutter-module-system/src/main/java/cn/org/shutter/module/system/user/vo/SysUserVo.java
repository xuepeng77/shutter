package cn.org.shutter.module.system.user.vo;

import cn.org.shutter.module.system.user.enums.SysUserStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 系统用户的响应类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统用户的响应对象")
public class SysUserVo implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 状态：0=禁用；1=启用。
     */
    @ApiModelProperty(value = "状态")
    private SysUserStatus status;

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
     * 创建人。
     */
    @ApiModelProperty(value = "创建人")
    private Integer createUser;

    /**
     * 创建时间。
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改人。
     */
    @ApiModelProperty(value = "修改人")
    private Integer modifyUser;

    /**
     * 修改时间。
     */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

}
