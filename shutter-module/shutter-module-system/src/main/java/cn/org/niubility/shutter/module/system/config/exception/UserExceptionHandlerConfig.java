package cn.org.niubility.shutter.module.system.config.exception;

import cn.org.niubility.shutter.core.common.bean.api.Result;
import cn.org.niubility.shutter.module.system.config.status.UserResultStatus;
import cn.org.niubility.shutter.module.system.user.exception.SysUserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户的异常处理。
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class UserExceptionHandlerConfig {

    /**
     * 系统用户不存在的异常处理。
     *
     * @param e 系统用户不存在的异常对象。
     * @return 异常响应。
     */
    @ExceptionHandler(value = SysUserNotFoundException.class)
    @ResponseBody
    public Result<String> sysUserNotFoundExceptionHandler(SysUserNotFoundException e) {
        return new Result.Builder<String>(UserResultStatus.USER_NOT_FOUND)
                .msg(e.getMessage()).build();
    }

}
