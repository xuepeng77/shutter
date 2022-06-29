package cn.org.shutter.module.system.func.vo;

import cn.org.shutter.core.common.bean.vo.BaseVo;
import cn.org.shutter.module.system.func.enums.SysFuncStatus;
import cn.org.shutter.module.system.func.enums.SysFuncType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统功能的响应类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统功能的响应对象")
public class SysFuncVo extends BaseVo {

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
     * 类型：0=菜单；1=按钮。
     */
    @ApiModelProperty(value = "类型")
    private SysFuncType type;

    /**
     * 转发地址。
     */
    @ApiModelProperty(value = "转发地址")
    private String redirect;

    /**
     * 路由地址。
     */
    @ApiModelProperty(value = "路由地址")
    private String path;

    /**
     * 组件。
     */
    @ApiModelProperty(value = "组件")
    private String component;

    /**
     * 标题。
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 打开方式。
     */
    @ApiModelProperty(value = "打开方式")
    private String target;

    /**
     * 图标。
     */
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 是否可见。
     */
    @ApiModelProperty(value = "是否可见")
    private Boolean visible;

    /**
     * 是否隐藏子功能。
     */
    @ApiModelProperty(value = "是否隐藏子功能")
    private Boolean hideChildren;

    /**
     * 是否隐藏头区域。
     */
    @ApiModelProperty(value = "是否隐藏头区域")
    private Boolean hideHeader;

    /**
     * 状态：0=禁用；1=启用。
     */
    @ApiModelProperty(value = "状态")
    private SysFuncStatus status;

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
     * 子系统功能。
     */
    @ApiModelProperty(value = "子系统功能")
    private List<SysFuncVo> children = new ArrayList<>();

}
