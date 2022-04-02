package cn.org.niubility.shutter.module.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.org.niubility.shutter.core.common.bean.api.Result;
import cn.org.niubility.shutter.module.enums.AuthResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统身份认证的异常处理。
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class AuthExceptionHandler {

    /**
     * 认证失败的异常处理。
     *
     * @param e 认证失败的异常对象。
     * @return 异常响应。
     */
    @ExceptionHandler(value = NotLoginException.class)
    @ResponseBody
    public Result<String> notLoginException(NotLoginException e) {
        log.error(e.getMessage());
        return new Result.Builder<String>(AuthResultStatus.NOT_LOGIN)
                .msg(e.getMessage()).build();
    }

}
