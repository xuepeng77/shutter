package cn.org.shutter.core.common.util;

import cn.org.shutter.core.common.json.JacksonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * Json工具类。
 *
 * @author xuepeng
 */
public class JsonUtil {

    /**
     * 创建Jackson的映射对象。
     */
    private static final ObjectMapper MAPPER = JacksonMapper.INSTANCE.getInstance();

    /**
     * 构造函数。
     */
    private JsonUtil() {
    }

    /**
     * 将一个对象转换成Json字符串。
     *
     * @param obj 要转换的对象。
     * @param <T> 要转换的对象的类型。
     * @return 对象的Json字符串。
     */
    public static <T> String objToStr(final T obj) {
        String result;
        if (Objects.isNull(obj)) {
            throw new NullPointerException("要转换的对象不能为空。");
        }
        // 判断要转换的对象是否是字符串
        // 如果是，则直接返回一个新的字符串。
        // 如果不是，则通过Jsckson转换成json字符串。
        if (obj instanceof String) {
            result = String.valueOf(obj);
        } else {
            try {
                result = MAPPER.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("对象转换Json字符串失败。", e);
            }
        }
        return result;
    }

    /**
     * 将一个Json字符串转换成对象。
     *
     * @param str   Json字符串。
     * @param clazz 要转换的对象的class对象。
     * @param <T>   要转换的对象的类型。
     * @return 转换后的对象。
     */
    public static <T> T strToObj(final String str, final Class<T> clazz) {
        checkJsonString(str);
        try {
            return MAPPER.readValue(str, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException("Json字符串转换对象失败。", e);
        }
    }

    /**
     * 将一个Json字符串转换成ArrayList。
     *
     * @param str Json字符串。
     * @param <T> List的类型。
     * @return 转换后的ArrayList。
     */
    public static <T> List<T> strToList(final String str) {
        checkJsonString(str);
        try {
            TypeReference<ArrayList<T>> typeRef = new TypeReference<ArrayList<T>>() {
            };
            return MAPPER.readValue(str, typeRef);
        } catch (IOException e) {
            throw new IllegalArgumentException("Json字符串转换List失败。", e);
        }
    }

    /**
     * 将一个Json字符串转换成HashMap。
     *
     * @param str Json字符串。
     * @param <K> Map的Key类型。
     * @param <V> Map的Value类型。
     * @return 转换后的HashMap。
     */
    public static <K, V> Map<K, V> strToMap(final String str) {
        checkJsonString(str);
        try {
            TypeReference<LinkedHashMap<K, V>> typeRef = new TypeReference<LinkedHashMap<K, V>>() {
            };
            return MAPPER.readValue(str, typeRef);
        } catch (IOException e) {
            throw new IllegalArgumentException("Json字符串转换Map失败。", e);
        }
    }

    /**
     * 将一个Json字符串转换成JsonNode。
     *
     * @param str Json字符串。
     * @return 转换后的JsonNode。
     */
    public static JsonNode strToJsonNode(final String str) {
        checkJsonString(str);
        try {
            return MAPPER.readTree(str);
        } catch (IOException e) {
            throw new IllegalArgumentException("Json字符串转换JsonNode失败。", e);
        }
    }

    /**
     * 检查Json字符串。
     *
     * @param str Json字符串。
     */
    private static void checkJsonString(final String str) {
        if (StringUtils.isBlank(str)) {
            throw new NullPointerException("Json字符串不能为空。");
        }
    }

}
