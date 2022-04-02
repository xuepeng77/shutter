package cn.org.niubility.shutter.core.common.bean.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页参数类。
 * 包括查询的页数，每页记录数，和排序信息。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "分页查询信息")
public class PageParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页数。
     */
    @ApiModelProperty(value = "当前页数", required = true, position = 1)
    private Integer pageNum;

    /**
     * 每页记录数。
     */
    @ApiModelProperty(value = "每页记录数", required = true, position = 2)
    private Integer pageSize;

    /**
     * 排序字段。
     */
    @ApiModelProperty(value = "排序字段", position = 3)
    private transient List<OrderInfo> orders = new ArrayList<>();

    /**
     * 分页查询时的排序信息。
     */
    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ApiModel(description = "查询排序信息")
    public static class OrderInfo implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 需要进行排序的字段
         */
        @ApiModelProperty(value = "字段名", required = true, position = 1)
        private String column;

        /**
         * 是否生序排列，默认生序
         */
        @ApiModelProperty(value = "排序规则", position = 2)
        private Boolean asc = Boolean.TRUE;

    }

}