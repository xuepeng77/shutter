package cn.org.shutter.sdk.satoken.service;

import cn.org.shutter.core.web.auth.AuthService;
import cn.org.shutter.core.web.auth.CurrentUser;

/**
 * SaToken的业务处理接口。
 *
 * @author xuepeng
 */
public interface SaTokenService extends AuthService {

    /**
     * 登录。
     *
     * @param currentUser 当前登录人。
     * @return 访问令牌。
     */
    String login(final CurrentUser currentUser);

    /**
     * @return 获取当前登录人。
     */
    CurrentUser getCurrentUser();

    /**
     * 登出。
     */
    void logout();

}
