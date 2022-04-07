package cn.org.shutter.sdk.mybatis.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.*;

import java.time.LocalDateTime;

/**
 * ORM实体类的业务类。
 * 定义了逻辑删除、创建人、创建时间、修改人、修改时间字段。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BizEntity extends BaseEntity {

    /**
     * 是否删除。
     * 数据库字段：deleted，tinyint(1)。
     */
    @TableLogic
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
