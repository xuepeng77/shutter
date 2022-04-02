package cn.org.niubility.shutter.core.web.log;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.org.niubility.shutter.core.common.consts.PunctuationConst;
import cn.org.niubility.shutter.core.common.util.ThreadLocalUtil;
import cn.org.niubility.shutter.core.web.auth.AuthService;
import cn.org.niubility.shutter.core.web.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

/**
 * API日志的切面类。
 * 关于API日志持久化，在Core中定义了ApiLogPersistent接口，具体实现由使用该功能的模块提供。
 *
 * @author xuepeng
 */
@Component
@Aspect
@Slf4j
public class ApiLogAspect {

    /**
     * 请求开始时间在ThreadLocal中的Key。
     */
    private static final String THREAD_LOCAL_KEY = "apiLogInfo";

    /**
     * 对被API日志注解修饰的方法进行切面处理。
     */
    @Pointcut(value = "@annotation(cn.org.niubility.shutter.core.web.log.ApiLog)")
    private void operation() {
        // 对请求进行切面处理
    }

    /**
     * 方法执行前的处理。
     *
     * @param joinPoint 连接点。
     */
    @Before("operation()")
    public void doBefore(JoinPoint joinPoint) {
        // 获取本次请求的元数据
        final HttpServletRequest request = WebUtil.getHttpServletRequest();
        final Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        ApiLogInfo apiLogInfo = new ApiLogInfo();
        // 封装Request信息
        setRequestInfo(apiLogInfo, request, joinPoint, method);
        // 封装UserAgent信息
        setUserAgentInfo(apiLogInfo, request);
        // 封装注解信息
        setAnnotationInfo(apiLogInfo, method.getAnnotation(ApiLog.class));
        // 保存封装信息到ThreadLocal中
        ThreadLocalUtil.put(THREAD_LOCAL_KEY, apiLogInfo);
    }

    /**
     * 方法返回后的处理。
     *
     * @param joinPoint 连接点。
     * @param result    返回值。
     */
    @AfterReturning(value = "operation()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        final ApiLogInfo apiLogInfo = (ApiLogInfo) ThreadLocalUtil.getAndRemove(THREAD_LOCAL_KEY);
        // 当前登录人主键
        if (authService.isLogin() && ObjectUtils.isEmpty(apiLogInfo.getUserId())) {
            apiLogInfo.setUserId(authService.getCurrentUserId());
        }
        apiLogInfo.setResult(result.toString());
        apiLogInfo.setExeTime(exeTime(apiLogInfo.getStartTime()));
        if (log.isDebugEnabled()) {
            log.debug("ApiLog请求: {}", apiLogInfo);
        }
        log.info("ApiLog请求: {}", apiLogInfo);
        // 持久化访问日志
        if (isPersistent(joinPoint)) {
            apiLogPersistent.saveAccessLog(apiLogInfo);
        }
    }

    /**
     * 方法异常后的处理。
     *
     * @param joinPoint 连接点。
     * @param throwable 异常。
     */
    @AfterThrowing(pointcut = "operation()", throwing = "throwable")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        final ApiLogInfo apiLogInfo = (ApiLogInfo) ThreadLocalUtil.getAndRemove(THREAD_LOCAL_KEY);
        // 当前登录人主键
        if (authService.isLogin() && ObjectUtils.isEmpty(apiLogInfo.getUserId())) {
            apiLogInfo.setUserId(authService.getCurrentUserId());
        }
        apiLogInfo.setError(throwable.getMessage());
        apiLogInfo.setExeTime(exeTime(apiLogInfo.getStartTime()));
        log.error(apiLogInfo.toString(), throwable);
        // 持久化错误日志
        if (isPersistent(joinPoint)) {
            apiLogPersistent.saveErrorLog(apiLogInfo);
        }
    }

    /**
     * 设置Request信息。
     *
     * @param apiLogInfo ApiLog信息。
     * @param request    请求对象。
     * @param joinPoint  连接点对象。
     * @param method     连接方法。
     */
    private void setRequestInfo(final ApiLogInfo apiLogInfo,
                                final HttpServletRequest request,
                                final JoinPoint joinPoint,
                                final Method method) {
        // 当前登录人主键
        if (authService.isLogin()) {
            apiLogInfo.setUserId(authService.getCurrentUserId());
        }
        // 请求信息
        apiLogInfo.setStartTime(LocalDateTime.now());
        apiLogInfo.setUrl(request.getRequestURL().toString());
        apiLogInfo.setUri(request.getRequestURI());
        apiLogInfo.setMethod(request.getMethod());
        apiLogInfo.setIp(WebUtil.getIPAddress(request));
        apiLogInfo.setClassName(joinPoint.getTarget().getClass().getName());
        // API Params信息
        final StringBuilder params = new StringBuilder();
        final Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> params
                .append(k)
                .append(PunctuationConst.EQUAL)
                .append(v[0])
                .append(PunctuationConst.SEMICOLON)
        );
        apiLogInfo.setMethodName(method.getName());
        apiLogInfo.setParams(params.toString());
        // API Args信息
        final StringBuilder args = new StringBuilder();
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            args.append(PunctuationConst.LEFT_SQUARE_BRACKETS)
                    .append("arg")
                    .append(i)
                    .append(PunctuationConst.COLON)
                    .append(joinPoint.getArgs()[i])
                    .append(PunctuationConst.RIGHT_SQUARE_BRACKETS);
        }
        apiLogInfo.setArgs(args.toString());
    }

    /**
     * 设置UserAgent信息。
     *
     * @param apiLogInfo ApiLog信息。
     * @param request    请求对象。
     */
    private void setUserAgentInfo(final ApiLogInfo apiLogInfo, final HttpServletRequest request) {
        final UserAgent userAgent = WebUtil.getUserAgent(request);
        apiLogInfo.setBrowser(userAgent.getBrowser().getName());
        apiLogInfo.setBrowserVersion(userAgent.getVersion());
        apiLogInfo.setPlatform(userAgent.getPlatform().getName());
        apiLogInfo.setOs(userAgent.getOs().getName());
        apiLogInfo.setOsVersion(userAgent.getOsVersion());
        apiLogInfo.setEngine(userAgent.getEngine().getName());
        apiLogInfo.setEngineVersion(userAgent.getEngineVersion());
    }

    /**
     * 设置注解信息。
     *
     * @param apiLogInfo       ApiLog信息。
     * @param apiLogAnnotation 注解。
     */
    private void setAnnotationInfo(final ApiLogInfo apiLogInfo, final ApiLog apiLogAnnotation) {
        apiLogInfo.setModule(apiLogAnnotation.module());
        apiLogInfo.setFunc(apiLogAnnotation.func());
        apiLogInfo.setRemark(apiLogAnnotation.remark());
        apiLogInfo.setAction(apiLogAnnotation.action().name());
    }

    /**
     * API日志是否需要持久化。
     *
     * @param joinPoint 连接点。
     * @return 是否需要持久化。
     */
    private boolean isPersistent(JoinPoint joinPoint) {
        final Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        return method.getAnnotation(ApiLog.class).persistent();
    }

    /**
     * @return 计算请求执行时间。
     */
    public long exeTime(final LocalDateTime startTime) {
        return LocalDateTimeUtil.between(startTime, LocalDateTime.now(), ChronoUnit.MILLIS);
    }

    /**
     * 自动装配身份认证业务处理接口。
     *
     * @param authService 身份认证业务处理接口。
     */
    @Autowired(required = false)
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 自动装配API日志持久化接口。
     *
     * @param apiLogPersistent ApiLog持久化接口。
     */
    @Autowired(required = false)
    public void setApiLogPersistent(ApiLogPersistent apiLogPersistent) {
        this.apiLogPersistent = apiLogPersistent;
    }

    /**
     * 身份认证业务处理接口。
     */
    private AuthService authService;

    /**
     * API日志持久化接口。
     */
    // TODO 同步、异步两种方式
    private ApiLogPersistent apiLogPersistent;

}
