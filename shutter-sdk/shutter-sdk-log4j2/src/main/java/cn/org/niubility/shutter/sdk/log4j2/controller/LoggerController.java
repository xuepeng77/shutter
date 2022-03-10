package cn.org.niubility.shutter.sdk.log4j2.controller;

import cn.org.niubility.shutter.core.common.bean.api.DefaultResultFactory;
import cn.org.niubility.shutter.core.common.bean.api.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志管理API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/logger")
@Slf4j
public class LoggerController {

    /**
     *
     */
    private static final String NAME = "ROOT";

    /**
     * @return 将日志切换到debug级别。
     */
    @PutMapping("/v1/open-debug")
    public Result<String> openDebugMode() {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(Boolean.FALSE);
        ctx.getConfiguration().getLoggerConfig(NAME).setLevel(Level.DEBUG);
        ctx.updateLoggers();
        log.info("日期开启debug模式。");
        return DefaultResultFactory.success("日志开启debug模式。", "开启成功。");
    }

    /**
     * @return 将日志切换到info级别。
     */
    @PutMapping("/v1/close-debug")
    public Result<String> closeDebug() {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(Boolean.FALSE);
        ctx.getConfiguration().getLoggerConfig(NAME).setLevel(Level.INFO);
        ctx.updateLoggers();
        log.info("日期关闭debug模式。");
        return DefaultResultFactory.success("日志关闭debug模式。", "关闭成功");
    }

}
