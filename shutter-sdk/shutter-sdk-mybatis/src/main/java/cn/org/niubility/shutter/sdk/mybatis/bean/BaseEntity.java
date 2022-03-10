package cn.org.niubility.shutter.sdk.mybatis.bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改人。
     */
    private Long modifyUser;

    /**
     * 修改时间。
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime;

}
