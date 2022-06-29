package cn.org.shutter.module.exception;

import cn.org.shutter.core.common.api.Result;
import cn.org.shutter.module.enums.SysDeptResultStatus;
import cn.org.shutter.module.system.dept.exception.SysDeptNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统组织机构的异常处理。
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class SysDeptExceptionHandler {

    /**
     * 系统组织机构不存在的异常处理。
     *
     * @param e 系统组织机构不存在的异常对象。
     * @return 异常响应。
     */
    @ExceptionHandler(value = SysDeptNotFoundException.class)
    @ResponseBody
    public Result<String> sysDeptExceptionHandler(SysDeptNotFoundException e) {
        log.error(e.getMessage(), e);
        return new Result.Builder<String>(SysDeptResultStatus.NOT_FOUND)
                .msg(e.getMessage()).build();
    }

}
