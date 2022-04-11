package cn.org.shutter.sdk.mybatis.util;

import cn.org.shutter.core.common.bean.dto.BaseDto;
import cn.org.shutter.sdk.mybatis.consts.QueryConst;
import cn.org.shutter.sdk.mybatis.entity.BaseEntity;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

/**
 * 分页对象工具类。
 *
 * @author xuepeng
 */
public class PageUtil {

    /**
     * 构造函数。
     */
    private PageUtil() {
    }

    /**
     * 创建一个MyBatis Plus分页对象。
     *
     * @param dto 数据传输对象的父类。
     * @param <T> 分页对象的类型。
     * @return MyBatis Plus分页对象。
     */
    public static <T extends BaseEntity> Page<T> createPage(final BaseDto dto) {
        // 设置分页参数
        int offset = 1;
        int limit = 20;
        if (!ObjectUtils.isEmpty(dto.getOffset())) offset = dto.getOffset();
        if (!ObjectUtils.isEmpty(dto.getLimit())) limit = dto.getLimit();
        final Page<T> page = new Page<>(offset, limit);
        // 设置排序参数
        if (!ObjectUtils.isEmpty(dto.getSort())) {
            page.addOrder(new OrderItem(
                    CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, dto.getSort()),
                    StringUtils.equalsAnyIgnoreCase(dto.getOrder(), QueryConst.ASC)
                            ? Boolean.TRUE : Boolean.FALSE)
            );
        }
        return page;
    }

}
