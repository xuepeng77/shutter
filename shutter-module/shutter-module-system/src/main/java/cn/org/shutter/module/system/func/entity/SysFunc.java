package cn.org.shutter.module.system.func.entity;

import cn.org.shutter.module.system.func.enums.SysFuncStatus;
import cn.org.shutter.module.system.func.enums.SysFuncType;
import cn.org.shutter.sdk.mybatis.entity.BizEntity;
import lombok.*;

/**
 * 系统功能的实体类。
 * 数据库表：sys_role，系统功能表。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysFunc extends BizEntity {

    /**
     * 父级主键。
     * 数据库字段：parent_id，bigint(20)。
     */
    private Integer parentId;

    /**
     * 名称。
     * 数据库字段：name，varchar(16)。
     */
    private String name;

    /**
     * 编号。
     * 数据库字段：code，varchar(32)。
     */
    private String code;

    /**
     * 类型：0=菜单；1=按钮。
     * 数据库字段：type，tinyint(2)。
     */
    private SysFuncType type;

    /**
     * 转发地址。
     * 数据库字段：redirect，varchar(128)。
     */
    private String redirect;

    /**
     * 路由地址。
     * 数据库字段：path，varchar(128)。
     */
    private String path;

    /**
     * 组件。
     * 数据库字段：component，varchar(32)。
     */
    private String component;

    /**
     * 标题。
     * 数据库字段：title，varchar(32)。
     */
    private String title;

    /**
     * 打开方式。
     * 数据库字段：target，varchar(16)。
     */
    private String target;

    /**
     * 图标。
     * 数据库字段：target，varchar(32)。
     */
    private String icon;

    /**
     * 是否可见。
     * 数据库字段：visible，tinyint(1)。
     */
    private Boolean visible;

    /**
     * 是否隐藏子功能。
     * 数据库字段：hide_children，tinyint(1)。
     */
    private Boolean hideChildren;

    /**
     * 是否隐藏头区域。
     * 数据库字段：hide_header，tinyint(1)。
     */
    private Boolean hideHeader;

    /**
     * 状态：0=禁用；1=启用。
     * 数据库字段：status，tinyint(2)。
     */
    private SysFuncStatus status;

    /**
     * 排序。
     * 数据库字段：order_id，int(11)。
     */
    private Integer orderId;

    /**
     * 备注。
     * 数据库字段：remark，varchar(256)。
     */
    private String remark;

}
