package cn.org.niubility.shutter.module.system.auth.service;

import cn.org.niubility.shutter.module.system.auth.dto.SysLoginDto;
import cn.org.niubility.shutter.sdk.verifycode.entity.VerifyCode;

/**
 * 系统身份认证的业务处理接口。
 *
 * @author xuepeng
 */
public interface AuthService {

    /**
     * @return 创建登录验证码。
     */
    VerifyCode createLoginVerifyCode();

    /**
     * 系统登录。
     * 当用户名密码不正确时，或当用户状态不可用时，抛出LoginFailedException异常对象。
     *
     * @param sysLoginDto 系统登录的数据传输对象。
     */
    void login(final SysLoginDto sysLoginDto);

    /**
     * 系统登出。
     */
    void logout();

}
