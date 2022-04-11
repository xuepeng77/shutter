package cn.org.shutter.core.common.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 响应对象的父类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "通用的的响应对象")
public class BaseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键。
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 创建人。
     */
    @ApiModelProperty(value = "创建人")
    private Integer createUser;

    /**
     * 创建时间。
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改人。
     */
    @ApiModelProperty(value = "修改人")
    private Integer modifyUser;

    /**
     * 修改时间。
     */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

}
