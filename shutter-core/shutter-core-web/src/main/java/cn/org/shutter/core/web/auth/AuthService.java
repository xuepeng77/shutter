package cn.org.shutter.core.web.auth;

public interface AuthService {

    /**
     * @return 判断是否登录。
     */
    boolean isLogin();

    /**
     * @return 获取当前登录人主键。
     */
    long getCurrentUserId();

    /**
     * @return 获取当前登录人帐号。
     */
    String getCurrentUserAccount();

}
