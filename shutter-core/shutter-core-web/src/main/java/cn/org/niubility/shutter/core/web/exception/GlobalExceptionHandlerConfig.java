package cn.org.niubility.shutter.core.web.exception;

import cn.org.niubility.shutter.core.common.bean.api.DefaultResultFactory;
import cn.org.niubility.shutter.core.common.bean.api.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的异常处理类。
 *
 * @author xuepeng
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandlerConfig {

    /**
     * API参数验证失败的异常处理。
     *
     * @param e API参数验证失败的异常对象。
     * @return 错误信息。
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        final Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return DefaultResultFactory.error("接口参数验证失败。", errors);
    }

}
