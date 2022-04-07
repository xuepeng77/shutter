package cn.org.shutter.core.web.log;

import java.lang.annotation.*;

/**
 * API日志的注解，基于切面记录API的请求与响应。
 *
 * @author xuepeng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {

    /**
     * @return 模块。
     */
    String module();

    /**
     * @return 功能。
     */
    String func();

    /**
     * @return 描述。
     */
    String remark();

    /**
     * @return 动作。
     */
    ApiLogAction action();

    /**
     * @return 是否持久化。
     */
    boolean persistent() default true;

}
