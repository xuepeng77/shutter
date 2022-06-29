package cn.org.shutter.module.system.pos.entity;

import cn.org.shutter.module.system.pos.enums.SysPosStatus;
import cn.org.shutter.sdk.mybatis.entity.BizEntity;
import lombok.*;

/**
 * 系统岗位的实体类。
 * 数据库表：sys_pos，系统岗位表。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysPos extends BizEntity {

    /**
     * 名称。
     * 数据库字段：name，varchar(32)。
     */
    private String name;

    /**
     * 编号。
     * 数据库字段：code，varchar(32)。
     */
    private String code;

    /**
     * 状态：0=禁用；1=启用。
     * 数据库字段：status，tinyint(2)。
     */
    private SysPosStatus status;

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
