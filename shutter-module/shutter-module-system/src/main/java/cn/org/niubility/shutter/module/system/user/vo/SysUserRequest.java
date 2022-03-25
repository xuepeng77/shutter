package cn.org.niubility.shutter.module.system.user.vo;

import cn.org.niubility.shutter.module.system.user.enums.SysUserStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 系统用户的请求类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统用户的请求对象")
public class SysUserRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 帐号。
     */
    @ApiModelProperty(value = "帐号", required = true)
    @NotBlank(message = "帐号不能为空")
    @Length(max = 32, message = "帐号长度不能大于32个字符")
    private String account;

    /**
     * 帐号。
     */
    @ApiModelProperty(value = "密码", required = true)
    @NotBlank(message = "密码不能为空")
    @Length(max = 32, message = "密码长度不能大于32个字符")
    private String password;

    /**
     * 手机号。
     */
    @ApiModelProperty(value = "手机号", required = true)
    @NotBlank(message = "手机号不能为空")
    @Length(max = 32, message = "手机号长度不能大于32个字符")
    private String phoneNumber;

    /**
     * 邮箱。
     */
    @ApiModelProperty(value = "邮箱", required = true)
    @NotBlank(message = "邮箱不能为空")
    @Length(max = 128, message = "邮箱长度不能大于128个字符")
    private String email;

    /**
     * 中文名。
     */
    @ApiModelProperty(value = "中文名", required = true)
    @NotBlank(message = "中文名不能为空")
    @Length(max = 8, message = "邮箱长度不能大于8个字符")
    private String chineseName;

    /**
     * 英文名。
     */
    @ApiModelProperty(value = "英文名")
    @Length(max = 64, message = "英文名长度不能大于64个字符")
    private String englishName;

    /**
     * 昵称。
     */
    @ApiModelProperty(value = "昵称")
    @Length(max = 32, message = "昵称长度不能大于32个字符")
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

}
