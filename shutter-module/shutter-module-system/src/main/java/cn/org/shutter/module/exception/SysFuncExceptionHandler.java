package cn.org.shutter.module.exception;

import cn.org.shutter.core.common.api.Result;
import cn.org.shutter.module.enums.SysFuncResultStatus;
import cn.org.shutter.module.system.func.exception.SysFuncNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统功能的异常处理。
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class SysFuncExceptionHandler {

    /**
     * 系统功能不存在的异常处理。
     *
     * @param e 系统功能不存在的异常对象。
     * @return 异常响应。
     */
    @ExceptionHandler(value = SysFuncNotFoundException.class)
    @ResponseBody
    public Result<String> sysFuncNotFoundException(SysFuncNotFoundException e) {
        log.error(e.getMessage(), e);
        return new Result.Builder<String>(SysFuncResultStatus.NOT_FOUND)
                .msg(e.getMessage()).build();
    }

}
