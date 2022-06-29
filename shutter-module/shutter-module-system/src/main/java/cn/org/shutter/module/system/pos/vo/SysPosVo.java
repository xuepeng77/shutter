package cn.org.shutter.module.system.pos.vo;

import cn.org.shutter.core.common.bean.vo.BaseVo;
import cn.org.shutter.module.system.pos.enums.SysPosStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 系统岗位的响应类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统岗位的响应对象")
public class SysPosVo extends BaseVo {

    /**
     * 名称。
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 编号。
     */
    @ApiModelProperty(value = "编号")
    private String code;

    /**
     * 状态：0=禁用；1=启用。
     */
    @ApiModelProperty(value = "状态")
    private SysPosStatus status;

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
