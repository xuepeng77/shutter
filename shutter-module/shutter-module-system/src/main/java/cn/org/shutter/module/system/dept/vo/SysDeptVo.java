package cn.org.shutter.module.system.dept.vo;

import cn.org.shutter.core.common.bean.vo.BaseVo;
import cn.org.shutter.module.system.dept.enums.SysDeptStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统组织结构的响应类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统组织机构的响应对象")
public class SysDeptVo extends BaseVo {

    /**
     * 父级主键。
     */
    @ApiModelProperty(value = "父级主键")
    private Integer parentId;

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
    private SysDeptStatus status;

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

    /**
     * 子系统部门。
     */
    @ApiModelProperty(value = "子系统部门")
    private List<SysDeptVo> children = new ArrayList<>();

}
