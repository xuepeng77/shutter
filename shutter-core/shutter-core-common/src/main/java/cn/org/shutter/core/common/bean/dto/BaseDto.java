package cn.org.shutter.core.common.bean.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 数据传输对象的父类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键。
     */
    private Long id;

    /**
     * 租户主键。
     */
    private Long tenantId;

    /**
     * 是否删除。
     */
    private Boolean deleted;

    /**
     * 创建人。
     */
    private Long createUser;

    /**
     * 创建时间。
     */
    private LocalDateTime createTime;

    /**
     * 修改人。
     */
    private Long modifyUser;

    /**
     * 修改时间。
     */
    private LocalDateTime modifyTime;

    /**
     * 开始创建时间。
     */
    private LocalDateTime beginCreateTime;

    /**
     * 结束创建时间。
     */
    private LocalDateTime endCreateTime;

    /**
     * 开始修改时间。
     */
    private LocalDateTime beginModifyTime;

    /**
     * 结束修改时间。
     */
    private LocalDateTime endModifyTime;

    /**
     * 当前页数。
     */
    private Integer offset;

    /**
     * 每页记录数。
     */
    private Integer limit;

    /**
     * 排序字段。
     */
    private String sort;

    /**
     * 排序规则。
     */
    private String order;

}
