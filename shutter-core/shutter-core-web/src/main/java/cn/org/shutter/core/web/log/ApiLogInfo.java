package cn.org.shutter.core.web.log;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * API日志类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ApiLogInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键。
     */
    private Long userId;
    
    /**
     * 请求开始时间。
     */
    private LocalDateTime startTime;

    /**
     * 请求Url。
     */
    private String url;

    /**
     * 请求Uri。
     */
    private String uri;

    /**
     * 请求Method。
     */
    private String method;

    /**
     * 请求IP。
     */
    private String ip;

    /**
     * 请求类名。
     */
    private String className;

    /**
     * 请求方法名。
     */
    private String methodName;

    /**
     * 请求路径参数。
     */
    private String params;

    /**
     * 请求方法参数。
     */
    private String args;

    /**
     * 返回值。
     */
    private String result;

    /**
     * 异常。
     */
    private String error;

    /**
     * 执行时间。
     */
    private Long exeTime;

    /**
     * 浏览器。
     */
    private String browser;

    /**
     * 浏览器版本。
     */
    private String browserVersion;

    /**
     * 平台。
     */
    private String platform;

    /**
     * 操作系统。
     */
    private String os;

    /**
     * 操作系统版本。
     */
    private String osVersion;

    /**
     * 引擎。
     */
    private String engine;

    /**
     * 引擎版本。
     */
    private String engineVersion;

    /**
     * 模块名称。
     */
    private String module;

    /**
     * 功能名称。
     */
    private String func;

    /**
     * 功能描述。
     */
    private String remark;

    /**
     * 动作描述。
     */
    private String action;

}
