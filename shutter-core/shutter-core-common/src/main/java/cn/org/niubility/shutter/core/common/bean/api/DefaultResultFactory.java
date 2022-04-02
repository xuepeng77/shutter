package cn.org.niubility.shutter.core.common.bean.api;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Result的简单工厂类。
 * 提供常用的返回Result的方法。
 *
 * @author xuepeng
 */
public class DefaultResultFactory {

    /**
     * 构造函数。
     */
    private DefaultResultFactory() {
    }

    /**
     * 默认的Data数据结构。
     */
    private static final Map<String, String> DEFAULT_DATA = new HashMap<>();

    /**
     * 创建成功的Result对象。
     *
     * @return 成功的Result对象。
     */
    public static Result<Map<String, String>> success() {
        return success(StringUtils.EMPTY);
    }

    /**
     * 创建成功的Result对象。
     *
     * @param msg 返回的消息。
     * @return 成功的Result对象。
     */
    public static Result<Map<String, String>> success(final String msg) {
        return new Result.Builder<Map<String, String>>(DefaultResultStatus.SUCCESS)
                .msg(msg)
                .data(DEFAULT_DATA).build();
    }

    /**
     * 创建成功的Result对象。
     *
     * @param msg  返回的消息。
     * @param data 返回的数据。
     * @return 成功的Result对象。
     */
    public static <T> Result<T> success(final String msg, final T data) {
        return new Result.Builder<T>(DefaultResultStatus.SUCCESS)
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 创建超时的Result对象。
     *
     * @return 超时的Result对象。
     */
    public static Result<Map<String, String>> timeout() {
        return timeout(StringUtils.EMPTY);
    }

    /**
     * 创建超时的Result对象。
     *
     * @param msg 返回的消息。
     * @return 超时的Result对象。
     */
    public static Result<Map<String, String>> timeout(final String msg) {
        return new Result.Builder<Map<String, String>>(DefaultResultStatus.TIMEOUT)
                .msg(msg)
                .data(DEFAULT_DATA).build();
    }

    /**
     * 创建超时的Result对象。
     *
     * @param msg  返回的消息。
     * @param data 返回的数据。
     * @return 超时的Result对象。
     */
    public static <T> Result<T> timeout(final String msg, final T data) {
        return new Result.Builder<T>(DefaultResultStatus.TIMEOUT)
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 创建参数错误的Result对象。
     *
     * @return 参数错误的Result对象。
     */
    public static Result<Map<String, String>> param() {
        return param(StringUtils.EMPTY);
    }

    /**
     * 创建参数错误的Result对象。
     *
     * @param msg 返回的消息。
     * @return 参数错误的Result对象。
     */
    public static Result<Map<String, String>> param(final String msg) {
        return new Result.Builder<Map<String, String>>(DefaultResultStatus.PARAM)
                .msg(msg)
                .data(DEFAULT_DATA).build();
    }

    /**
     * 创建参数错误的Result对象。
     *
     * @param msg  返回的消息。
     * @param data 返回的数据。
     * @return 参数错误的Result对象。
     */
    public static <T> Result<T> param(final String msg, final T data) {
        return new Result.Builder<T>(DefaultResultStatus.PARAM)
                .msg(msg)
                .data(data)
                .build();
    }


    /**
     * 创建失败的Result对象。
     *
     * @return 失败的Result对象。
     */
    public static Result<Map<String, String>> fail() {
        return fail(StringUtils.EMPTY);
    }

    /**
     * 创建失败的Result对象。
     *
     * @param msg 返回的消息。
     * @return 失败的Result对象。
     */
    public static Result<Map<String, String>> fail(final String msg) {
        return new Result.Builder<Map<String, String>>(DefaultResultStatus.FAIL)
                .msg(msg)
                .data(DEFAULT_DATA).build();
    }

    /**
     * 创建失败的Result对象。
     *
     * @param msg  返回的消息。
     * @param data 返回的数据。
     * @return 失败的Result对象。
     */
    public static <T> Result<T> fail(final String msg, final T data) {
        return new Result.Builder<T>(DefaultResultStatus.FAIL)
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 创建授权失败的Result对象。
     *
     * @return 授权失败的Result对象。
     */
    public static Result<Map<String, String>> permissions() {
        return permissions(StringUtils.EMPTY);
    }

    /**
     * 创建授权失败的Result对象。
     *
     * @param msg 返回的消息。
     * @return 授权失败的Result对象。
     */
    public static Result<Map<String, String>> permissions(final String msg) {
        return new Result.Builder<Map<String, String>>(DefaultResultStatus.PERMISSIONS)
                .msg(msg)
                .data(DEFAULT_DATA).build();
    }

    /**
     * 创建授权失败的Result对象。
     *
     * @param msg  返回的消息。
     * @param data 返回的数据。
     * @return 授权失败的Result对象。
     */
    public static <T> Result<T> permissions(final String msg, final T data) {
        return new Result.Builder<T>(DefaultResultStatus.PERMISSIONS)
                .msg(msg)
                .data(data)
                .build();
    }

    /**
     * 创建系统异常的Result对象。
     *
     * @return 系统异常的Result对象。
     */
    public static Result<Map<String, String>> error() {
        return error(StringUtils.EMPTY);
    }

    /**
     * 创建系统异常的Result对象。
     *
     * @param msg 返回的消息。
     * @return 系统异常的Result对象。
     */
    public static Result<Map<String, String>> error(final String msg) {
        return new Result.Builder<Map<String, String>>(DefaultResultStatus.ERROR)
                .msg(msg)
                .data(DEFAULT_DATA).build();
    }

    /**
     * 创建系统异常的Result对象。
     *
     * @param msg  返回的消息。
     * @param data 返回的数据。
     * @return 系统异常的Result对象。
     */
    public static <T> Result<T> error(final String msg, final T data) {
        return new Result.Builder<T>(DefaultResultStatus.ERROR).
                msg(msg)
                .data(data)
                .build();
    }

}
