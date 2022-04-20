package cn.org.shutter.module.system.role.vo;

import cn.org.shutter.core.common.bean.vo.BaseVo;
import cn.org.shutter.module.system.role.enums.SysRoleStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 系统角色的响应类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统角色的响应对象")
public class SysRoleVo extends BaseVo {

    /**
     * 唯一标识。
     */
    @ApiModelProperty(value = "唯一标识")
    private String code;

    /**
     * 名称。
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 状态：0=禁用；1=启用。
     */
    @ApiModelProperty(value = "状态")
    private SysRoleStatus status;

    /**
     * 排序。
     */
    @ApiModelProperty(value = "排序")
    private Integer orderId;

    /**
     * 备注。
     */
    @ApiModelProperty(value = "备注")
    private String remark;

}
