package cn.org.niubility.shutter.core.common.bean.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询的的查询结果信息。
 * 包括：当前页数、每页显示的条数、总条数、总页数和查询的数据。
 *
 * @param <T> 查询出的数据的类型。
 * @author xuepeng
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "分页响应信息")
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 构造函数。
     *
     * @param currentPage 当前页数。
     * @param pageSize    每页显示行数。
     * @param totalCount  总页数。
     * @param record      本页的数据列表。
     */
    public PageResult(long currentPage, long pageSize, long totalCount, List<T> record) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        // 计算总页码
        pageCount = (totalCount + pageSize - 1) / pageSize;
        this.record = record;
    }

    /**
     * 当前页数。
     */
    @ApiModelProperty(value = "当前页数")
    private long currentPage;

    /**
     * 每页显示多少条。
     */
    @ApiModelProperty(value = "每页显示多少条")
    private long pageSize;

    /**
     * 总页数。
     */
    @ApiModelProperty(value = "总页数")
    private long pageCount;

    /**
     * 总记录数。
     */
    @ApiModelProperty(value = "总记录数")
    private long totalCount;

    /**
     * 本页的数据。
     */
    @ApiModelProperty(value = "本页的数据")
    private transient List<T> record = new ArrayList<>();

}