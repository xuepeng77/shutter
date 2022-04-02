package cn.org.niubility.shutter.module.exception;

import cn.org.niubility.shutter.core.common.bean.api.Result;
import cn.org.niubility.shutter.module.enums.VerifyCodeResultStatus;
import cn.org.niubility.shutter.module.system.auth.exception.VerifyCodeIncorrectException;
import cn.org.niubility.shutter.sdk.verifycode.exception.VerifyCodeExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 验证码的异常处理。
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class VerifyCodeExceptionHandler {

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
        return new Result.Builder<String>(VerifyCodeResultStatus.EXPIRED)
                .msg(e.getMessage()).build();
    }

    /**
     * 验证码不正确的异常处理。
     *
     * @param e 验证码不正确的异常对象。
     * @return 异常响应。
     */
    @ExceptionHandler(value = VerifyCodeIncorrectException.class)
    @ResponseBody
    public Result<String> verifyCodeIncorrectException(VerifyCodeIncorrectException e) {
        log.error(e.getMessage());
        return new Result.Builder<String>(VerifyCodeResultStatus.INCORRECT)
                .msg(e.getMessage()).build();
    }

}
