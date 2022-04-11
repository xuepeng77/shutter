package cn.org.shutter.core.common.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页响应类。
 * 包括：当前页数、每页显示的条数、总条数、总页数和查询的数据。
 *
 * @param <T> 查询出的数据的类型。
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "分页响应信息")
public class PageVo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页数。
     */
    @ApiModelProperty(value = "当前页数")
    private long current;

    /**
     * 每页显示多少行。
     */
    @ApiModelProperty(value = "每页显示多少行")
    private long size;

    /**
     * 总页数。
     */
    @ApiModelProperty(value = "总页数")
    private long total;

    /**
     * 本页的数据。
     */
    @ApiModelProperty(value = "本页的数据")
    private transient List<T> records = new ArrayList<>();

}