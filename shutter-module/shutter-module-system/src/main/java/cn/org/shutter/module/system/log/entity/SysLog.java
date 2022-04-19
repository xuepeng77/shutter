package cn.org.shutter.module.system.log.entity;

import cn.org.shutter.module.system.log.enums.SysLogType;
import cn.org.shutter.sdk.mybatis.entity.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 系统日志的实体类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysLog extends BaseEntity {

    /**
     * 日志类型：0=访问日志；1=错误日志；
     * 数据库字段：type，tinyint(2)。
     */
    private SysLogType type;

    /**
     * 用户。
     * 数据库字段：op_user，varchar(32)。
     */
    private String opUser;

    /**
     * 创建时间。
     * 数据库字段：op_time，timestamp。
     */
    private LocalDateTime opTime;

    /**
     * 请求地址。
     * 数据库字段：url，varchar(128)。
     */
    private String url;

    /**
     * 请求资源。
     * 数据库字段：uri，varchar(128)。
     */
    private String uri;

    /**
     * 请求方式。
     * 数据库字段：method，varchar(16)。
     */
    private String method;

    /**
     * 请求IP地址。
     * 数据库字段：ip，varchar(32)。
     */
    private String ip;

    /**
     * 请求类名。
     * 数据库字段：class_name，varchar(256)。
     */
    private String className;

    /**
     * 请求方法名。
     * 数据库字段：method_name，varchar(32)。
     */
    private String methodName;

    /**
     * 请求路径参数。
     * 数据库字段：params，text。
     */
    private String params;

    /**
     * 请求方法参数。
     * 数据库字段：args，text。
     */
    private String args;

    /**
     * 返回值。
     * 数据库字段：result，text。
     */
    private String result;

    /**
     * 异常。
     * 数据库字段：error，text。
     */
    private String error;

    /**
     * 执行时间。
     * 数据库字段：exe_time，text。
     */
    private Long exeTime;

    /**
     * 浏览器。
     * 数据库字段：browser，varchar(32)。
     */
    private String browser;

    /**
     * 浏览器版本。
     * 数据库字段：browser_version，varchar(32)。
     */
    private String browserVersion;

    /**
     * 平台。
     * 数据库字段：platform，varchar(32)。
     */
    private String platform;

    /**
     * 操作系统。
     * 数据库字段：os，varchar(32)。
     */
    private String os;

    /**
     * 操作系统版本。
     * 数据库字段：os_version，varchar(32)。
     */
    private String osVersion;

    /**
     * 引擎。
     * 数据库字段：engine，varchar(32)。
     */
    private String engine;

    /**
     * 引擎版本。
     * 数据库字段：engine_version，varchar(32)。
     */
    private String engineVersion;

    /**
     * 模块名称。
     * 数据库字段：module，varchar(16)。
     */
    private String module;

    /**
     * 功能名称。
     * 数据库字段：func，varchar(16)。
     */
    private String func;

    /**
     * 功能描述。
     * 数据库字段：desc，varchar(32)。
     */
    private String remark;

    /**
     * 动作描述。
     * 数据库字段：action，varchar(16)。
     */
    private String action;

}
