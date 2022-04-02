package cn.org.niubility.shutter.module.system.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 系统登录的请求类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统登录的请求对象")
public class SysLoginRequest implements Serializable {

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
    @ApiModelProperty(value = "帐号", required = true)
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 验证码编号
     */
    @ApiModelProperty(value = "验证码编号", required = true)
    @NotBlank(message = "验证码编号不能为空")
    @Length(max = 32, message = "验证码编号长度不能大于32个字符")
    private String uuid;

    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码", required = true)
    @NotBlank(message = "验证码不能为空")
    private String code;

}
