package cn.org.shutter.module.system.login.service;

import cn.org.shutter.module.system.login.dto.SysLoginDto;
import cn.org.shutter.module.system.login.exception.SysLoginFailedException;
import cn.org.shutter.module.system.login.exception.SysLoginVerifyCodeExpiredException;
import cn.org.shutter.module.system.login.exception.SysLoginVerifyCodeIncorrectException;
import cn.org.shutter.module.system.user.dto.SysUserDto;
import cn.org.shutter.module.system.user.enums.SysUserStatus;
import cn.org.shutter.module.system.user.service.SysUserService;
import cn.org.shutter.sdk.satoken.service.SaTokenService;
import cn.org.shutter.sdk.satoken.service.SaTokenUser;
import cn.org.shutter.sdk.verifycode.entity.VerifyCode;
import cn.org.shutter.sdk.verifycode.exception.VerifyCodeExpiredException;
import cn.org.shutter.sdk.verifycode.service.VerifyCodeService;
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
     * 当验证码不存在或已过期时，抛出SysLoginVerifyCodeExpiredException异常对象。
     * 当验证码不正确时，抛出SysLoginVerifyCodeIncorrectException异常对象。
     * 当用户名密码不正确时，或当用户状态不可用时，抛出LoginFailedException异常对象。
     *
     * @param sysLoginDto 系统登录的数据传输对象。
     */
    @Override
    public void login(final SysLoginDto sysLoginDto) {
        // 检查验证码是否正确
        checkVerifyCode(sysLoginDto);
        // 检查是否可登录
        final SysUserDto sysUserDto = sysUserService.findByAccount(sysLoginDto.getAccount());
        checkLogin(sysLoginDto, sysUserDto);
        // TODO 判断租户状态
        // TODO 判断租户有效期
        // 系统登录
        final SaTokenUser saToeknUser = sysUserService.getSysUserMapper().dtoToCurrentUser(sysUserDto);
        saTokenService.login(saToeknUser);
        // 更新登录信息
        updateLoginInfo(sysLoginDto, sysUserDto);
    }

    /**
     * 系统登出。
     */
    @Override
    public void logout() {
        saTokenService.logout();
    }

    /**
     * 检查验证码是否正确。
     *
     * @param sysLoginDto 系统登录的数据传输对象。
     */
    private void checkVerifyCode(final SysLoginDto sysLoginDto) {
        final VerifyCode verifyCode = VerifyCode.builder()
                .uuid(sysLoginDto.getUuid())
                .code(sysLoginDto.getCode())
                .build();
        boolean validate;
        try {
            validate = imageVerifyCodeService.validate(verifyCode);
        } catch (VerifyCodeExpiredException e) {
            throw new SysLoginVerifyCodeExpiredException("登录验证码不存在或已过期。");
        }
        if (!validate) {
            throw new SysLoginVerifyCodeIncorrectException("登录验证码不正确。");
        }
    }

    /**
     * 检查是否可以登录。
     *
     * @param sysLoginDto 系统登录的数据传输对象。
     * @param sysUserDto  系统用户的数据传输对象。
     */
    private void checkLogin(final SysLoginDto sysLoginDto, final SysUserDto sysUserDto) {
        if (ObjectUtils.isEmpty(sysUserDto) ||
                !sysUserService.verifyPassword(sysLoginDto.getPassword(), sysUserDto.getPassword())
        ) {
            throw new SysLoginFailedException("用户名或密码不正确。");
        }
        if (sysUserDto.getStatus() == SysUserStatus.DISABLE) {
            throw new SysLoginFailedException("用户状态不可用。");
        }
    }

    /**
     * 更新登录信息。
     *
     * @param sysLoginDto 系统登录的数据传输对象。
     * @param sysUserDto  系统用户的数据传输对象。
     */
    private void updateLoginInfo(final SysLoginDto sysLoginDto, final SysUserDto sysUserDto) {
        // 更新用户登录信息
        final SysUserDto sysUserDtoForUpdate = new SysUserDto();
        sysUserDtoForUpdate.setId(sysUserDto.getId());
        sysUserDtoForUpdate.setLoginIp(sysLoginDto.getIp());
        sysUserDtoForUpdate.setLoginTime(LocalDateTime.now());
        sysUserService.update(sysUserDtoForUpdate);
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
     * 自动装配SaToken的业务处理接口。
     *
     * @param saTokenService SaToken的业务处理接口。
     */
    @Autowired
    public void setSaTokenService(SaTokenService saTokenService) {
        this.saTokenService = saTokenService;
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
     * SaToken的业务处理接口。
     */
    private SaTokenService saTokenService;

}
