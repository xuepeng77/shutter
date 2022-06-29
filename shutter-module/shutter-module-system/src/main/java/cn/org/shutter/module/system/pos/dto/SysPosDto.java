package cn.org.shutter.module.system.pos.dto;

import cn.org.shutter.core.common.bean.dto.BaseDto;
import cn.org.shutter.module.system.pos.enums.SysPosStatus;
import lombok.*;

/**
 * 系统岗位的数据传输类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysPosDto extends BaseDto {

    /**
     * 名称。
     */
    private String name;

    /**
     * 编号。
     */
    private String code;

    /**
     * 状态：0=禁用；1=启用。
     */
    private SysPosStatus status;

    /**
     * 排序。
     */
    private Integer orderId;

    /**
     * 备注。
     */
    private String remark;

}
