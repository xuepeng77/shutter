package cn.org.niubility.shutter.module.system.user.service.password;

/**
 * 登录密码策略的抽象类。
 *
 * @author xuepeng
 */
public abstract class AbstractPasswordStrategy implements PasswordStrategy {

    /**
     * 生成登录密码。
     *
     * @return 登录密码。
     */
    public String generate() {
        // 生成随机的登录密码
        final String password = random();
        // 加密随机生成的密码
        return encode(password);
    }

    /**
     * 生成随机的登录密码。
     *
     * @return 登录密码。
     */
    protected abstract String random();

    /**
     * 使用算法对密码进行加密。
     *
     * @param password 对密码进行加密。
     * @return 登录密码。
     */
    protected abstract String encode(final String password);

}
