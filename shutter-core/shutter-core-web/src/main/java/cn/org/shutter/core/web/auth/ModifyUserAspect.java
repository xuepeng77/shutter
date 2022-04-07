package cn.org.shutter.core.web.auth;

import cn.org.shutter.core.common.bean.vo.BaseRequestVo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 当前用户的切面类。
 * 用于在方法调用时，获取当前登录人，用作ModifyUser注解。
 *
 * @author xuepeng
 */
@Component
@Aspect
public class ModifyUserAspect {

    /**
     * 设置修改人。
     */
    @Pointcut("@annotation(cn.org.shutter.core.web.auth.ModifyUser)")
    private void modifyUser() {
        // 创建修改人
    }

    /**
     * 设置本次操作的修改人。
     *
     * @param joinPoint 连接点。
     */
    @Before("modifyUser()")
    public void doBefore(final JoinPoint joinPoint) {
        for (final Object arg : joinPoint.getArgs()) {
            if (arg instanceof BaseRequestVo && authService.isLogin()) {
                final long currentUserId = authService.getCurrentUserId();
                final BaseRequestVo baseRequestVo = (BaseRequestVo) arg;
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
