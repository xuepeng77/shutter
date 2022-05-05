package cn.org.shutter.core.web.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 当前登录人授权的角色。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserRole {

    /**
     * 主键。
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 唯一标识。
     */
    @ApiModelProperty(value = "唯一标识")
    private String code;

    /**
     * 名称。
     */
    @ApiModelProperty(value = "名称")
    private String name;

}
