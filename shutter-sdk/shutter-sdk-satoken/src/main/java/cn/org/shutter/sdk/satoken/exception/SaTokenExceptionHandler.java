package cn.org.shutter.sdk.satoken.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.org.shutter.core.common.api.Result;
import cn.org.shutter.sdk.satoken.enums.SaTokenResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class SaTokenExceptionHandler {

    /**
     * 认证失败的异常处理。
     *
     * @param e 认证失败的异常对象。
     * @return 异常响应。
     */
    @ExceptionHandler(value = NotLoginException.class)
    @ResponseBody
    public ResponseEntity<String> notLoginException(NotLoginException e) {
        log.error(e.getMessage());
        final Result<String> result = new Result.Builder<String>(SaTokenResultStatus.NOT_LOGIN).msg(e.getMessage()).build();
        return new ResponseEntity<>(result.toString(), HttpStatus.UNAUTHORIZED);
    }

}
