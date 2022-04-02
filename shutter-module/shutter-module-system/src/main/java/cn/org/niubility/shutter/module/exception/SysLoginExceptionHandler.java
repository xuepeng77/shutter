package cn.org.niubility.shutter.module.exception;

import cn.org.niubility.shutter.core.common.bean.api.Result;
import cn.org.niubility.shutter.module.enums.SysLoginResultStatus;
import cn.org.niubility.shutter.module.system.auth.exception.LoginFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统登录的异常处理。
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class SysLoginExceptionHandler {

    /**
     * 登录系统失败的异常处理。
     *
     * @param e 登录系统失败的异常对象。
     * @return 异常响应。
     */
    @ExceptionHandler(value = LoginFailedException.class)
    @ResponseBody
    public Result<String> loginFailedException(LoginFailedException e) {
        log.error(e.getMessage());
        return new Result.Builder<String>(SysLoginResultStatus.LOGIN_FAILED)
                .msg(e.getMessage()).build();
    }

}
