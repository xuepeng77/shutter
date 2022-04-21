package cn.org.shutter.module.system.role.param;

import cn.org.shutter.core.common.bean.param.BaseParam;
import cn.org.shutter.module.system.role.enums.SysRoleStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 系统角色的请求类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统角色的请求对象")
public class SysRoleParam extends BaseParam {

    /**
     * 唯一标识。
     */
    @ApiModelProperty(value = "唯一标识", required = true)
    @NotBlank(message = "唯一标识不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "唯一标识长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String code;

    /**
     * 名称。
     */
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "名称长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String name;

    /**
     * 状态：0=禁用；1=启用。
     */
    @ApiModelProperty(value = "状态")
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private SysRoleStatus status;

    /**
     * 排序。
     */
    @ApiModelProperty(value = "排序")
    @NotNull(message = "排序不能为空", groups = {create.class, update.class})
    private Integer orderId;

    /**
     * 备注。
     */
    @ApiModelProperty(value = "备注")
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class})
    private String remark;

}
