package cn.org.shutter.module.system.role.entity;

import cn.org.shutter.module.system.role.enums.SysRoleStatus;
import cn.org.shutter.sdk.mybatis.entity.BizEntity;
import lombok.*;

/**
 * 系统角色的实体类。
 * 数据库表：sys_role，系统角色表。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysRole extends BizEntity {

    /**
     * 唯一标识。
     * 数据库字段：code，varchar(32)。
     */
    private String code;

    /**
     * 名称。
     * 数据库字段：name，varchar(32)。
     */
    private String name;

    /**
     * 备注。
     * 数据库字段：remark，varchar(256)。
     */
    private String remark;

    /**
     * 状态：0=禁用；1=启用。
     * 数据库字段：status，tinyint(2)。
     */
    private SysRoleStatus status;

    /**
     * 排序。
     * 数据库字段：order_id，int(11)。
     */
    private Integer orderId;

}
