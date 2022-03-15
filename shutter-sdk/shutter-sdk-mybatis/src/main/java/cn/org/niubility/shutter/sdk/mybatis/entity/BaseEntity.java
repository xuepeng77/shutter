package cn.org.niubility.shutter.sdk.mybatis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ORM实体类的父类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键。
     * 数据库字段：id，bigint(20)。
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户主键。
     * 数据库字段：tenant_id，bigint(20)。
     */
    private Long tenantId;

    /**
     * 是否删除。
     * 数据库字段：deleted，tinyint(1)。
     */
    private Boolean deleted;

    /**
     * 创建人。
     * 数据库字段：create_user，bigint(20)。
     */
    private Long createUser;

    /**
     * 创建时间。
     * 数据库字段：create_time，timestamp。
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改人。
     * 数据库字段：modify_user，bigint(20)。
     */
    private Long modifyUser;

    /**
     * 修改时间。
     * 数据库字段：modify_time，timestamp。
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

}
