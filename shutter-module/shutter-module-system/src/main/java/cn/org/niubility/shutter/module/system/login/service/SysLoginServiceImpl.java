package cn.org.niubility.shutter.module.system.login.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.org.niubility.shutter.module.property.SystemProperty;
import cn.org.niubility.shutter.module.system.login.dto.SysLoginDto;
import cn.org.niubility.shutter.module.system.login.exception.SysLoginFailedException;
import cn.org.niubility.shutter.module.system.login.exception.SysLoginVerifyCodeIncorrectException;
import cn.org.niubility.shutter.module.system.user.dto.SysUserDto;
import cn.org.niubility.shutter.module.system.user.enums.SysUserStatus;
import cn.org.niubility.shutter.module.system.user.service.SysUserService;
import cn.org.niubility.shutter.module.system.user.service.password.PasswordStrategy;
import cn.org.niubility.shutter.module.system.user.service.password.PasswordStrategyFactory;
import cn.org.niubility.shutter.sdk.verifycode.entity.VerifyCode;
import cn.org.niubility.shutter.sdk.verifycode.service.VerifyCodeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
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
public class SysLoginServiceImpl implements SysLoginService {

    /**
     * @return 创建登录验证码。
     */
    @Override
    public VerifyCode createLoginVerifyCode() {
        return imageVerifyCodeService.send(StringUtils.EMPTY);
    }

    /**
     * 系统登录。
     * 当用户名密码不正确时，或当用户状态不可用时，抛出LoginFailedException异常对象。
     *
     * @param sysLoginDto 系统登录的数据传输对象。
     */
    @Override
    public void login(final SysLoginDto sysLoginDto) {
        // 判断验证码是否正确
        final VerifyCode verifyCode = VerifyCode.builder()
                .uuid(sysLoginDto.getUuid())
                .code(sysLoginDto.getCode())
                .build();
        if (!imageVerifyCodeService.validate(verifyCode)) {
            throw new SysLoginVerifyCodeIncorrectException("验证码不正确。");
        }
        // 判断是否可登录
        final SysUserDto sysUserDto = sysUserService.findByAccount(sysLoginDto.getAccount());
        if (ObjectUtils.isEmpty(sysUserDto) ||
                !getPasswordStrategy().verify(sysLoginDto.getPassword(), sysUserDto.getPassword())
        ) {
            throw new SysLoginFailedException("用户名或密码不正确。");
        }
        if (sysUserDto.getStatus() == SysUserStatus.DISABLE) {
            throw new SysLoginFailedException("用户状态不可用。");
        }
        // TODO 判断租户状态
        // TODO 判断租户有效期
        // 系统登录
        StpUtil.login(sysUserDto.getId());
        // 更新用户登录信息
        final SysUserDto sysUserDtoForUpdate = new SysUserDto();
        sysUserDtoForUpdate.setId(sysUserDto.getId());
        sysUserDtoForUpdate.setLoginIp(sysLoginDto.getIp());
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
     * 自动装配验证码的业务处理接口。
     *
     * @param imageVerifyCodeService 验证码的业务处理接口。
     */
    @Autowired
    public void setImageVerifyCodeService(VerifyCodeService imageVerifyCodeService) {
        this.imageVerifyCodeService = imageVerifyCodeService;
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
     * 验证码的业务处理接口。
     */
    private VerifyCodeService imageVerifyCodeService;

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
