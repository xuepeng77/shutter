package cn.org.shutter.module.system.func.param;

import cn.org.shutter.core.common.bean.param.BaseParam;
import cn.org.shutter.module.system.func.enums.SysFuncStatus;
import cn.org.shutter.module.system.func.enums.SysFuncType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 系统功能的请求类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统功能的请求对象")
public class SysFuncParam extends BaseParam {

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
    @Length(max = 16, message = "名称长度不能大于16个字符", groups = {create.class, update.class, page.class})
    private String name;

    /**
     * 编号。
     */
    @ApiModelProperty(value = "编号", required = true)
    @NotBlank(message = "编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String code;

    /**
     * 类型：0=菜单；1=按钮。
     */
    @ApiModelProperty(value = "类型：0=菜单；1=按钮", required = true)
    @NotNull(message = "类型不能为空", groups = {create.class, update.class})
    private SysFuncType type;

    /**
     * 转发地址。
     */
    @ApiModelProperty(value = "转发地址")
    @Length(max = 128, message = "转发地址长度不能大于128个字符", groups = {create.class, update.class, page.class})
    private String redirect;

    /**
     * 路由地址。
     */
    @ApiModelProperty(value = "路由地址")
    @Length(max = 128, message = "路由地址长度不能大于128个字符", groups = {create.class, update.class, page.class})
    private String path;

    /**
     * 组件。
     */
    @ApiModelProperty(value = "组件")
    @Length(max = 32, message = "组件长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String component;

    /**
     * 标题。
     */
    @ApiModelProperty(value = "标题", required = true)
    @NotBlank(message = "标题不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "标题长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String title;

    /**
     * 打开方式。
     */
    @ApiModelProperty(value = "打开方式")
    @Length(max = 16, message = "组件长度不能大于16个字符", groups = {create.class, update.class, page.class})
    private String target;

    /**
     * 图标。
     */
    @ApiModelProperty(value = "图标")
    @Length(max = 32, message = "组件长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String icon;

    /**
     * 是否可见。
     */
    @ApiModelProperty(value = "是否可见", required = true)
    @NotNull(message = "是否可见不能为空", groups = {create.class, update.class})
    private Boolean visible;

    /**
     * 是否隐藏子功能。
     */
    @ApiModelProperty(value = "是否隐藏子功能", required = true)
    @NotNull(message = "是否隐藏子功能不能为空", groups = {create.class, update.class})
    private Boolean hideChildren;

    /**
     * 是否隐藏头区域。
     */
    @ApiModelProperty(value = "是否隐藏头区域", required = true)
    @NotNull(message = "是否隐藏头区域不能为空", groups = {create.class, update.class})
    private Boolean hideHeader;

    /**
     * 状态：0=禁用；1=启用。
     */
    @ApiModelProperty(value = "状态：0=禁用；1=启用", required = true)
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private SysFuncStatus status;

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
