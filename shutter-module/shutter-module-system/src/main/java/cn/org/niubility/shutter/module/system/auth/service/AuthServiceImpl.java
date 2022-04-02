package cn.org.niubility.shutter.module.system.auth.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.org.niubility.shutter.module.system.auth.exception.LoginFailedException;
import cn.org.niubility.shutter.module.system.config.SystemProperty;
import cn.org.niubility.shutter.module.system.user.dto.SysUserDto;
import cn.org.niubility.shutter.module.system.user.enums.SysUserStatus;
import cn.org.niubility.shutter.module.system.user.service.SysUserService;
import cn.org.niubility.shutter.module.system.user.service.password.PasswordStrategy;
import cn.org.niubility.shutter.module.system.user.service.password.PasswordStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 系统身份认证的业务处理实现类。
 *
 * @author xuepeng
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    /**
     * 系统登录。
     * 当用户名密码不正确时，或当用户状态不可用时，抛出LoginFailedException异常对象。
     *
     * @param account  用户名。
     * @param password 密码。
     * @param ip       IP地址。
     */
    @Override
    public void login(final String account, final String password, final String ip) {
        final SysUserDto sysUserDto = sysUserService.findByAccount(account);
        // 验证登录是否成功
        if (ObjectUtils.isEmpty(sysUserDto) || !getPasswordStrategy().verify(password, sysUserDto.getPassword())) {
            throw new LoginFailedException("用户名或密码不正确。");
        }
        if (sysUserDto.getStatus() == SysUserStatus.DISABLE) {
            throw new LoginFailedException("用户状态不可用。");
        }
        // TODO 判断租户状态
        // TODO 判断租户有效期
        // 系统登录
        StpUtil.login(sysUserDto.getId());
        // 更新用户登录信息
        final SysUserDto sysUserDtoForUpdate = new SysUserDto();
        sysUserDtoForUpdate.setId(sysUserDto.getId());
        sysUserDtoForUpdate.setLoginIp(ip);
        sysUserDtoForUpdate.setLoginTime(LocalDateTime.now());
        sysUserService.update(sysUserDtoForUpdate);
    }

    /**
     * 系统登出。
     */
    @Override
    public void logout() {
        StpUtil.logout();
    }

    /**
     * @return 获取登录密码策略的接口。
     */
    private PasswordStrategy getPasswordStrategy() {
        return passwordStrategyFactory.getInstance(systemProperty.getSysUserProperty().getPasswordStrategyType());
    }

    /**
     * 自动装配系统用户的业务处理接口。
     *
     * @param sysUserService 系统用户的业务处理接口。
     */
    @Autowired
    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 自动装配登录密码策略的工厂类。
     *
     * @param passwordStrategyFactory 登录密码策略的工厂类。
     */
    @Autowired
    public void setPasswordStrategyFactory(PasswordStrategyFactory passwordStrategyFactory) {
        this.passwordStrategyFactory = passwordStrategyFactory;
    }

    /**
     * 自动装配系统管理的自定义配置类。
     *
     * @param systemProperty 系统管理的自定义配置类。
     */
    @Autowired
    public void setSystemProperty(SystemProperty systemProperty) {
        this.systemProperty = systemProperty;
    }

    /**
     * 系统用户的业务处理接口。
     */
    private SysUserService sysUserService;

    /**
     * 登录密码策略的工厂类。
     */
    private PasswordStrategyFactory passwordStrategyFactory;

    /**
     * 系统管理的自定义配置类。
     */
    private SystemProperty systemProperty;

}
