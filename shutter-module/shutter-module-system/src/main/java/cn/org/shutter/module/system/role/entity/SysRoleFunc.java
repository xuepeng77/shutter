package cn.org.shutter.module.system.role.entity;

import cn.org.shutter.sdk.mybatis.entity.BaseEntity;
import lombok.*;

/**
 * 系统角色与系统功能关系的实体类。
 * 数据库表：sys_role_func，系统角色与系统功能关系表。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleFunc extends BaseEntity {

    /**
     * 角色主键。
     * 数据库字段：role_id，bigint(20)。
     */
    private Long roleId;

    /**
     * 功能主键。
     * 数据库字段：func_id，bigint(20)。
     */
    private Long funcId;

}
