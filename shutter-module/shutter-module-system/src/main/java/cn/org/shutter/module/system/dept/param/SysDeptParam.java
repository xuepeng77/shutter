package cn.org.shutter.module.system.dept.param;

import cn.org.shutter.core.common.bean.param.BaseParam;
import cn.org.shutter.module.system.dept.enums.SysDeptStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 系统组织机构的请求类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统组织机构的请求对象")
public class SysDeptParam extends BaseParam {

    /**
     * 父级主键。
     */
    @ApiModelProperty(value = "父级主键", required = true)
    @NotNull(message = "父级主键不能为空", groups = {create.class, update.class})
    private Long parentId;

    /**
     * 名称。
     */
    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "名称不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "名称长度不能大于16个字符", groups = {create.class, update.class, page.class})
    private String name;

    /**
     * 编号。
     */
    @ApiModelProperty(value = "编号", required = true)
    @NotBlank(message = "编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String code;

    /**
     * 状态：0=禁用；1=启用。
     */
    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private SysDeptStatus status;

    /**
     * 排序。
     */
    @ApiModelProperty(value = "排序", required = true)
    @NotNull(message = "排序不能为空", groups = {create.class, update.class})
    private Integer orderId;

    /**
     * 备注。
     */
    @ApiModelProperty(value = "备注")
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String remark;

}
