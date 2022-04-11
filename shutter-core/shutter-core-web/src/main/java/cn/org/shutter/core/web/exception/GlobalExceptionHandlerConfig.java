package cn.org.shutter.core.web.exception;

import cn.org.shutter.core.common.api.DefaultResultFactory;
import cn.org.shutter.core.common.api.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
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
     * 处理RequestBody的参数错误。
     *
     * @param e API参数验证失败的异常对象。
     * @return 错误信息。
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        return DefaultResultFactory.error("接口参数验证失败。", result(e.getBindingResult()));
    }

    /**
     * API参数验证失败的异常处理。
     * 处理RequestParam中的参数错误。
     *
     * @param e API参数验证失败的异常对象。
     * @return 错误信息。
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Result<Map<String, String>> bindException(BindException e) {
        log.error(e.getMessage());
        return DefaultResultFactory.error("接口参数验证失败。", result(e.getBindingResult()));
    }

    /**
     * 封装异常错误信息。
     *
     * @param bindingResult 异常信息。
     * @return 信息集合。
     */
    private Map<String, String> result(BindingResult bindingResult) {
        final Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
