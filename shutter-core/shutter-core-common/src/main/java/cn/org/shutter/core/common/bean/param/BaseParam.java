package cn.org.shutter.core.common.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 请求参数的父类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "通用的的请求对象")
public class BaseParam implements Serializable {

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

    /**
     * 开始创建时间。
     */
    @ApiModelProperty(value = "开始创建时间")
    private LocalDateTime beginCreateTime;

    /**
     * 结束创建时间。
     */
    @ApiModelProperty(value = "结束创建时间")
    private LocalDateTime endCreateTime;

    /**
     * 开始修改时间。
     */
    @ApiModelProperty(value = "开始修改时间")
    private LocalDateTime beginModifyTime;

    /**
     * 结束修改时间。
     */
    @ApiModelProperty(value = "结束修改时间")
    private LocalDateTime endModifyTime;

    /**
     * 当前页数。
     */
    @ApiModelProperty(value = "当前页数")
    private Integer offset;

    /**
     * 每页记录数。
     */
    @ApiModelProperty(value = "每页记录数")
    private Integer limit;

    /**
     * 排序字段。
     */
    @ApiModelProperty(value = "排序字段")
    private String sort;

    /**
     * 排序规则。
     */
    @ApiModelProperty(value = "排序规则")
    private String order;

    /**
     * 参数校验分组：分页。
     */
    public @interface page {
    }

    /**
     * 参数校验分组：列表。
     */
    public @interface list {
    }

    /**
     * 参数校验分组：下拉。
     */
    public @interface dropDown {
    }

    /**
     * 参数校验分组：创建。
     */
    public @interface create {
    }

    /**
     * 参数校验分组：修改。
     */
    public @interface update {
    }

    /**
     * 参数校验分组：修改密码。
     */
    public @interface updatePwd {
    }

    /**
     * 参数校验分组：重置密码。
     */
    public @interface resetPwd {
    }

    /**
     * 参数校验分组：上传头像。
     */
    public @interface avatar {
    }

    /**
     * 参数校验分组：删除。
     */
    public @interface delete {
    }

    /**
     * 参数校验分组：详情。
     */
    public @interface detail {
    }

    /**
     * 参数校验分组：强制退出。
     */
    public @interface force {
    }

    /**
     * 参数校验分组：停用。
     */
    public @interface disable {
    }

    /**
     * 参数校验分组：启用。
     */
    public @interface enable {
    }

    /**
     * 参数校验分组：导出。
     */
    public @interface export {
    }

}
