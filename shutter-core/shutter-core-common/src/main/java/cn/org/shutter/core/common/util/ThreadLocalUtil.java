package cn.org.shutter.core.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal工具类。
 *
 * @author xuepeng
 */
public class ThreadLocalUtil {

    /**
     * ThreadLocal对象。
     */
    private static final ThreadLocal<Map<String, Object>> THREAD_VARIABLES
            = ThreadLocal.withInitial(HashMap::new);

    /**
     * 构造函数。
     */
    private ThreadLocalUtil() {
    }

    /**
     * 设置对象到ThreadLocal中。
     *
     * @param key   键。
     * @param value 值。
     */
    public static void put(final String key, final Object value) {
        THREAD_VARIABLES.get().put(key, value);
    }

    /**
     * 从ThreadLocal中获取对象。
     *
     * @param key 键。
     * @return 对象。
     */
    public static Object get(final String key) {
        return THREAD_VARIABLES.get().get(key);
    }

    /**
     * 从ThreadLocal中获取对象，并从ThreadLocal中删除该对象。
     *
     * @param key 键。
     * @return 对象。
     */
    public static Object getAndRemove(final String key) {
        try {
            return get(key);
        } finally {
            remove(key);
        }
    }

    /**
     * 从ThreadLocal中删除对象。
     *
     * @param key 键。
     */
    public static void remove(final String key) {
        THREAD_VARIABLES.get().remove(key);
    }

    /**
     * 清空ThreadLocal。
     */
    public static void clear() {
        THREAD_VARIABLES.remove();
    }

}
