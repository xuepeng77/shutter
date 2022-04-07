package cn.org.niubility.shutter.module.exception;

import cn.org.niubility.shutter.core.common.bean.api.Result;
import cn.org.niubility.shutter.module.enums.SysLoginResultStatus;
import cn.org.niubility.shutter.module.system.login.exception.SysLoginFailedException;
import cn.org.niubility.shutter.module.system.login.exception.SysLoginVerifyCodeIncorrectException;
import cn.org.niubility.shutter.sdk.verifycode.exception.VerifyCodeExpiredException;
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
    @ExceptionHandler(value = SysLoginFailedException.class)
    @ResponseBody
    public Result<String> sysLoginFailedException(SysLoginFailedException e) {
        log.error(e.getMessage());
        return new Result.Builder<String>(SysLoginResultStatus.LOGIN_FAILED)
                .msg(e.getMessage()).build();
    }

    /**
     * 验证码过期或不存在的异常处理。
     *
     * @param e 验证码过期或不存在的异常对象。
     * @return 异常响应。
     */
    @ExceptionHandler(value = VerifyCodeExpiredException.class)
    @ResponseBody
    public Result<String> verifyCodeExpiredException(VerifyCodeExpiredException e) {
        log.error(e.getMessage());
        return new Result.Builder<String>(SysLoginResultStatus.VERIFY_CODE_EXPIRED)
                .msg(e.getMessage()).build();
    }

    /**
     * 验证码不正确的异常处理。
     *
     * @param e 验证码不正确的异常对象。
     * @return 异常响应。
     */
    @ExceptionHandler(value = SysLoginVerifyCodeIncorrectException.class)
    @ResponseBody
    public Result<String> verifyCodeIncorrectException(SysLoginVerifyCodeIncorrectException e) {
        log.error(e.getMessage());
        return new Result.Builder<String>(SysLoginResultStatus.VERIFY_CODE_INCORRECT)
                .msg(e.getMessage()).build();
    }

}
