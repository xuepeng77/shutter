package cn.org.shutter.core.common.util;

import java.io.Serializable;
import java.util.List;

/**
 * 验证是否存在的方法接口。
 * 用于验证某个值是否存在。
 *
 * @author xuepeng
 */
@FunctionalInterface
public interface ExistsFunction<T> {

    /**
     * 判断值是否存在。
     * 存在返回true，不存在返回false。
     *
     * @param list  根据要验证的值查询出的数据列表。
     * @param value 要验证是否存在的值。
     * @return 是否存在。
     */
    boolean exists(List<T> list, Serializable value);

}

