package cn.org.shutter.module.system.role.entity;

import cn.org.shutter.sdk.mybatis.entity.BaseEntity;
import lombok.*;

/**
 * 系统角色与系统用户关系的实体类。
 * 数据库表：sys_role_user，系统角色表。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleUser extends BaseEntity {

    /**
     * 角色主键。
     * 数据库字段：role_id，bigint(20)。
     */
    private Long roleId;

    /**
     * 用户主键。
     * 数据库字段：user_id，bigint(20)。
     */
    private Long userId;

}
