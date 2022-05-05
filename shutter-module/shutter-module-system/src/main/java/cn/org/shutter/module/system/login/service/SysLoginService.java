package cn.org.shutter.module.system.login.service;

import cn.org.shutter.core.web.auth.CurrentUser;
import cn.org.shutter.module.system.login.dto.SysLoginDto;
import cn.org.shutter.sdk.verifycode.entity.VerifyCode;

/**
 * 系统身份认证的业务处理接口。
 *
 * @author xuepeng
 */
public interface SysLoginService {

    /**
     * @return 创建登录验证码。
     */
    VerifyCode createLoginVerifyCode();

    /**
     * 系统登录。
     * 当验证码不存在或已过期时，抛出SysLoginVerifyCodeExpiredException异常对象。
     * 当验证码不正确时，抛出SysLoginVerifyCodeIncorrectException异常对象。
     * 当用户名密码不正确时，或当用户状态不可用时，抛出LoginFailedException异常对象。
     *
     * @param sysLoginDto 系统登录的数据传输对象。
     * @return 访问令牌。
     */
    String login(final SysLoginDto sysLoginDto);

    /**
     * @return 获取当前登录人。
     */
    CurrentUser getCurrentUser();

    /**
     * 系统登出。
     */
    void logout();

}
