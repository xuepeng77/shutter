package cn.org.shutter.sdk.mybatis.util;

import cn.org.shutter.core.common.bean.dto.BaseDto;
import cn.org.shutter.sdk.mybatis.entity.BaseEntity;
import cn.org.shutter.sdk.mybatis.entity.BizEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDateTime;

/**
 * 查询条件工具类。
 *
 * @author xuepeng
 */
public class QueryWrapperUtil {

    /**
     * 构造函数。
     */
    private QueryWrapperUtil() {
    }

    /**
     * 创建QueryWrapper查询对象。
     *
     * @param <E> QueryWrapper中的泛型类，集成自BaseEntity类。
     * @return QueryWrapper查询对象。
     */
    public static <E extends BaseEntity> QueryWrapper<E> createQueryWrapper() {
        return new QueryWrapper<>();
    }

    /**
     * 创建带条件的QueryWrapper。
     *
     * @param dto 数据传输对象。
     * @param <D> QueryWrapper中的数据传输对象。
     * @param <E> QueryWrapper中的实体类对象。
     * @return QueryWrapper查询对象。
     */
    public static <D extends BaseDto, E extends BizEntity> QueryWrapper<E> createQueryWrapper(final D dto) {
        final QueryWrapper<E> wrapper = createQueryWrapper();
        final LambdaQueryWrapper<E> lambda = wrapper.lambda();
        // 创建时间查询条件
        if (ObjectUtils.isNotEmpty(dto.getBeginCreateTime())
                && ObjectUtils.isNotEmpty(dto.getEndCreateTime())) {
            lambda.between(E::getCreateTime, dto.getBeginCreateTime(), dto.getEndCreateTime());
        }
        if (ObjectUtils.isNotEmpty(dto.getBeginCreateTime())
                && ObjectUtils.isNotEmpty(dto.getEndCreateTime())) {
            lambda.between(E::getCreateTime, dto.getBeginCreateTime(), LocalDateTime.now());
        }
        if (ObjectUtils.isEmpty(dto.getBeginCreateTime())
                && ObjectUtils.isNotEmpty(dto.getEndCreateTime())) {
            lambda.le(E::getCreateTime, dto.getEndCreateTime());
        }
        // 修改时间查询条件
        if (ObjectUtils.isNotEmpty(dto.getBeginModifyTime())
                && ObjectUtils.isNotEmpty(dto.getEndModifyTime())) {
            lambda.between(E::getModifyTime, dto.getBeginModifyTime(), dto.getEndModifyTime());
        }
        if (ObjectUtils.isNotEmpty(dto.getBeginModifyTime())
                && ObjectUtils.isNotEmpty(dto.getEndModifyTime())) {
            lambda.between(E::getModifyTime, dto.getBeginModifyTime(), LocalDateTime.now());
        }
        if (ObjectUtils.isEmpty(dto.getBeginModifyTime())
                && ObjectUtils.isNotEmpty(dto.getEndModifyTime())) {
            lambda.le(E::getModifyTime, dto.getEndModifyTime());
        }
        return wrapper;
    }

}
