package cn.org.shutter.module.exception;

import cn.org.shutter.core.common.api.Result;
import cn.org.shutter.module.enums.SysRoleResultStatus;
import cn.org.shutter.module.system.role.exception.SysRoleNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统角色的异常处理。
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class SysRoleExceptionHandler {

    /**
     * 系统角色不存在的异常处理。
     *
     * @param e 系统角色不存在的异常对象。
     * @return 异常响应。
     */
    @ExceptionHandler(value = SysRoleNotFoundException.class)
    @ResponseBody
    public Result<String> sysRoleNotFoundException(SysRoleNotFoundException e) {
        log.error(e.getMessage(), e);
        return new Result.Builder<String>(SysRoleResultStatus.NOT_FOUND)
                .msg(e.getMessage()).build();
    }

}
