package cn.org.shutter.sdk.log4j2.controller;

import cn.org.shutter.core.common.api.DefaultResultFactory;
import cn.org.shutter.core.common.api.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Log4j2的API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/log")
@Slf4j
@Api(tags = "日志工具的API")
@ApiSupport(order = 99)
public class LogController {

    /**
     * Logger的名称，对应日志配置文件中<Loggers>下的标签名称。
     */
    private static final String NAME = "ROOT";

    /**
     * @return 将日志切换到DEBUG级别。
     */
    @PutMapping("/v1/open-debug")
    @ApiOperation(value = "开启DEBUG模式")
    @ApiOperationSupport(order = 1)
    public Result<String> openDebugMode() {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(Boolean.FALSE);
        ctx.getConfiguration().getLoggerConfig(NAME).setLevel(Level.DEBUG);
        ctx.updateLoggers();
        log.debug("Log4j2开启INFO模式。");
        return DefaultResultFactory.success("开启DEBUG模式。", "DEBUG模式开启成功。");
    }

    /**
     * @return 将日志切换到INFO级别。
     */
    @PutMapping("/v1/open-info")
    @ApiOperation(value = "开启INFO模式")
    @ApiOperationSupport(order = 2)
    public Result<String> openInfoMode() {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(Boolean.FALSE);
        ctx.getConfiguration().getLoggerConfig(NAME).setLevel(Level.INFO);
        ctx.updateLoggers();
        log.info("Log4j2开启INFO模式。");
        return DefaultResultFactory.success("开启INFO模式。", "INFO模式开启成功。");
    }

    /**
     * @return 将日志切换到WARN级别。
     */
    @PutMapping("/v1/open-warn")
    @ApiOperation(value = "开启WARN模式")
    @ApiOperationSupport(order = 3)
    public Result<String> openWarnMode() {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(Boolean.FALSE);
        ctx.getConfiguration().getLoggerConfig(NAME).setLevel(Level.WARN);
        ctx.updateLoggers();
        log.warn("Log4j2开启WARN模式。");
        return DefaultResultFactory.success("开启WARN模式。", "WARN模式开启成功。");
    }

    /**
     * @return 将日志切换到ERROR级别。
     */
    @PutMapping("/v1/open-error")
    @ApiOperation(value = "开启ERROR模式")
    @ApiOperationSupport(order = 4)
    public Result<String> openErrorMode() {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(Boolean.FALSE);
        ctx.getConfiguration().getLoggerConfig(NAME).setLevel(Level.ERROR);
        ctx.updateLoggers();
        log.error("Log4j2开启ERROR模式。");
        return DefaultResultFactory.success("开启ERROR模式。", "ERROR模式开启成功。");
    }

}
