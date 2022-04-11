package cn.org.shutter.core.web.auth;

import cn.org.shutter.core.common.bean.param.BaseParam;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 当前用户的切面类。
 * 用于在方法调用时，获取当前登录人，用作CreateUser注解。
 *
 * @author xuepeng
 */
@Component
@Aspect
public class CreateUserAspect {

    /**
     * 设置创建人。
     */
    @Pointcut("@annotation(cn.org.shutter.core.web.auth.CreateUser)")
    private void createUser() {
        // 设置创建人
    }

    /**
     * 设置本次操作的创建人。
     *
     * @param joinPoint 连接点。
     */
    @Before("createUser()")
    public void doBefore(final JoinPoint joinPoint) {
        for (final Object arg : joinPoint.getArgs()) {
            if (arg instanceof BaseParam && authService.isLogin()) {
                final long currentUserId = authService.getCurrentUserId();
                final BaseParam baseRequestVo = (BaseParam) arg;
                baseRequestVo.setCreateUser(currentUserId);
                baseRequestVo.setModifyUser(currentUserId);
            }
        }
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
     * 身份认证业务处理接口。
     */
    private AuthService authService;

}
