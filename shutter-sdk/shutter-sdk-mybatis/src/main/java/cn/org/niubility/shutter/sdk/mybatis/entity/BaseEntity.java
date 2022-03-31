package cn.org.niubility.shutter.sdk.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.io.Serializable;

/**
 * ORM实体类的父类。
 * 定义了主键和租户主键字段。
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

}
