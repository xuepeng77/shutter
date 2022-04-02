package cn.org.niubility.shutter.module.system.auth.service;

/**
 * 系统身份认证的业务处理接口。
 *
 * @author xuepeng
 */
public interface AuthService {

    /**
     * 系统登录。
     * 当用户名密码不正确时，或当用户状态不可用时，抛出LoginFailedException异常对象。
     *
     * @param account  用户名。
     * @param password 密码。
     * @param ip       IP地址。
     */
    void login(final String account, final String password, final String ip);

    /**
     * 系统登出。
     */
    void logout();

}
