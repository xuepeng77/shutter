package cn.org.shutter.core.web.log;

/**
 * API日志的持久化接口。
 *
 * @author xuepeng
 */
public interface ApiLogPersistent {

    /**
     * 持久化保存API访问日志。
     *
     * @param apiLogEntity API日志对象。
     */
    void saveAccessLog(final ApiLogInfo apiLogEntity);

    /**
     * 持久化保存API错误日志。
     *
     * @param apiLogEntity API日志对象。
     */
    void saveErrorLog(final ApiLogInfo apiLogEntity);

}
