package cn.org.shutter.core.web.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 当前登录人授权的功能。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserFunc {

    /**
     * 主键。
     */
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 父级主键。
     */
    @ApiModelProperty(value = "父级主键")
    private Integer parentId;

    /**
     * 名称。
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 编号。
     */
    @ApiModelProperty(value = "编号")
    private String code;

    /**
     * 转发地址。
     */
    @ApiModelProperty(value = "转发地址")
    private String redirect;

    /**
     * 路由地址。
     */
    @ApiModelProperty(value = "路由地址")
    private String path;

    /**
     * 组件。
     */
    @ApiModelProperty(value = "组件")
    private String component;

    /**
     * 标题。
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 打开方式。
     */
    @ApiModelProperty(value = "打开方式")
    private String target;

    /**
     * 图标。
     */
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 是否可见。
     */
    @ApiModelProperty(value = "是否可见")
    private Boolean visible;

    /**
     * 是否隐藏子功能。
     */
    @ApiModelProperty(value = "是否隐藏子功能")
    private Boolean hideChildren;

    /**
     * 是否隐藏头区域。
     */
    @ApiModelProperty(value = "是否隐藏头区域")
    private Boolean hideHeader;

}
