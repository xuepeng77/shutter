package cn.org.shutter.sdk.satoken.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.org.shutter.core.web.auth.CurrentUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * SaToken的业务处理实现类。
 * 实现了AuthService接口，为ApiLog提供获取登录用户能力。
 */
@Component
@Slf4j
public class SaTokenServiceImpl implements SaTokenService {

    /**
     * Session Key。
     */
    private static final String SESSION_KEY = "user";

    /**
     * 未登录情况下的默认帐号。
     */
    private static final String NOT_LOGIN_USER_ACCOUNT = "未登录";

    /**
     * @return 判断是否登录。
     */
    @Override
    public boolean isLogin() {
        return StpUtil.isLogin();
    }

    /**
     * 登录。
     *
     * @param currentUser 当前登录人。
     * @return 访问令牌。
     */
    @Override
    public String login(final CurrentUser currentUser) {
        StpUtil.login(currentUser.getId());
        StpUtil.getSession().set(SESSION_KEY, currentUser);
        return StpUtil.getTokenValue();
    }

    /**
     * @return 获取当前登录人主键。
     */
    @Override
    public long getCurrentUserId() {
        return StpUtil.getLoginIdAsLong();
    }

    /**
     * @return 获取当前登录人帐号。
     */
    @Override
    public String getCurrentUserAccount() {
        final CurrentUser currentUser = getCurrentUser();
        return ObjectUtils.isEmpty(currentUser)
                ? NOT_LOGIN_USER_ACCOUNT : currentUser.getAccount();
    }

    /**
     * @return 获取当前登录人。
     */
    @Override
    public CurrentUser getCurrentUser() {
        return (CurrentUser) StpUtil.getSession().get(SESSION_KEY);
    }

    /**
     * 登出。
     */
    @Override
    public void logout() {
        if (StpUtil.isLogin()) {
            StpUtil.getSession().delete(SESSION_KEY);
            StpUtil.logout();
        }
    }

}
