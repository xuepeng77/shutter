package cn.org.shutter.sdk.satoken.service;

import cn.org.shutter.core.web.auth.AuthService;

/**
 * SaToken的业务处理接口。
 *
 * @author xuepeng
 */
public interface SaTokenService extends AuthService {

    /**
     * 登录。
     *
     * @param saTokenUser SaToken用户的实体类。
     */
    void login(final SaTokenUser saTokenUser);

    /**
     * @return 获取当前登录人。
     */
    SaTokenUser getCurrentUser();

    /**
     * 登出。
     */
    void logout();

}
