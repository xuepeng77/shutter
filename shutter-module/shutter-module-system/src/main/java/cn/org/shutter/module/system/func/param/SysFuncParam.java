package cn.org.shutter.module.system.func.param;

import cn.org.shutter.core.common.bean.param.BaseParam;
import cn.org.shutter.module.system.func.enums.SysFuncStatus;
import cn.org.shutter.module.system.func.enums.SysFuncType;
import io.swagger.annotations.ApiModel;
import lombok.*;

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
@ApiModel(value = "系统角色的请求对象")
public class SysFuncParam extends BaseParam {

    /**
     * 父级主键。
     */
    private Integer parentId;

    /**
     * 名称。
     */
    private String name;

    /**
     * 编号。
     */
    private String code;

    /**
     * 类型：0=菜单；1=按钮。
     */
    private SysFuncType type;

    /**
     * 转发地址。
     */
    private String redirect;

    /**
     * 路由地址。
     */
    private String path;

    /**
     * 组件。
     */
    private String component;

    /**
     * 标题。
     */
    private String title;

    /**
     * 打开方式。
     */
    private String target;

    /**
     * 图标。
     */
    private String icon;

    /**
     * 是否可见。
     */
    private Boolean visible;

    /**
     * 是否隐藏子功能。
     */
    private Boolean hideChildren;

    /**
     * 是否隐藏头区域。
     */
    private Boolean hideHeader;

    /**
     * 状态：0=禁用；1=启用。
     */
    private SysFuncStatus status;

    /**
     * 排序。
     */
    private Integer orderId;

    /**
     * 备注。
     */
    private String remark;

}
