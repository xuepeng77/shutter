package cn.org.niubility.shutter.core.common.util;

import cn.hutool.core.date.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间工具类。
 * 关于操作LocalDateTime的通用方法定义在该类。
 * 继承了Hutool的LocalDateTimeUtil
 *
 * @author xuepeng
 */
@Slf4j
public class LocalDateTimeExUtil extends LocalDateTimeUtil {

    /**
     * 构造函数。
     */
    private LocalDateTimeExUtil() {
    }

    /**
     * @return 获取从现在到明天0点的秒数（系统默认时区）。
     */
    public static Duration nowToMidnight() {
        return nowToMidnight(ZoneId.systemDefault());
    }

    /**
     * 获取从现在到明天0点的秒数。
     *
     * @param zoneId 时区。
     * @return 从现在到明天的秒数。
     */
    public static Duration nowToMidnight(final ZoneId zoneId) {
        // 当前时间
        final LocalDateTime now = LocalDateTime.now(zoneId);
        // 明天0点
        final LocalDateTime nextDay = LocalDate.now(zoneId)
                .plusDays(1)
                .atStartOfDay();
        if (log.isDebugEnabled()) {
            log.debug("now is {}, nextDay is {}",
                    now.format(DateTimeFormatter.ISO_DATE_TIME),
                    nextDay.format(DateTimeFormatter.ISO_DATE_TIME)
            );
        }
        // 距明天0点有多少秒。
        return Duration.between(now, nextDay);
    }

}
