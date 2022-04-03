package cn.org.niubility.shutter.core.common.bean.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * 请求对象的父类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequestVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 创建人。
     */
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 修改人。
     */
    @ApiModelProperty(value = "修改人")
    private Long modifyUser;

}
