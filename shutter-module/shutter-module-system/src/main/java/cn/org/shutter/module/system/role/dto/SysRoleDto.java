package cn.org.shutter.module.system.role.dto;

import cn.org.shutter.core.common.bean.dto.BaseDto;
import cn.org.shutter.module.system.role.enums.SysRoleStatus;
import lombok.*;

/**
 * 系统角色的数据传输类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleDto extends BaseDto {

    /**
     * 唯一标识。
     */
    private String code;

    /**
     * 名称。
     */
    private String name;

    /**
     * 状态：0=禁用；1=启用。
     */
    private SysRoleStatus status;

    /**
     * 排序。
     */
    private Integer orderId;

    /**
     * 备注。
     */
    private String remark;

}
