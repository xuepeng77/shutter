package cn.org.shutter.module.system.login.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.org.shutter.core.common.api.DefaultResultFactory;
import cn.org.shutter.core.common.api.Result;
import cn.org.shutter.core.web.auth.CurrentUser;
import cn.org.shutter.core.web.bean.BaseController;
import cn.org.shutter.core.web.log.ApiLog;
import cn.org.shutter.core.web.log.ApiLogAction;
import cn.org.shutter.module.system.login.dto.SysLoginDto;
import cn.org.shutter.module.system.login.mapper.SysLoginMapper;
import cn.org.shutter.module.system.login.param.SysLoginParam;
import cn.org.shutter.module.system.login.service.SysLoginService;
import cn.org.shutter.sdk.verifycode.entity.VerifyCode;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统身份认证的API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/auth")
@Slf4j
@Api(tags = "身份认证的API")
@ApiSupport(order = 1)
@SaCheckLogin
public class SysLoginController extends BaseController {

    /**
     * 获取登录验证码。
     *
     * @return 验证码。
     */
    @GetMapping("/v1/verify-code")
    @ApiOperation(value = "获取验证码")
    @ApiOperationSupport(order = 1)
    @ApiLog(module = "系统管理", func = "身份认证", remark = "获取验证码", action = ApiLogAction.CREATE)
    public Result<VerifyCode> createLoginVerifyCode() {
        final VerifyCode result = sysLoginService.createLoginVerifyCode();
        return DefaultResultFactory.success("获取验证码成功。", result);
    }

    /**
     * 系统登录。
     *
     * @param sysLoginParam 系统登录的请求对象。
     * @return 访问令牌。
     */
    @PostMapping("/v1/login")
    @ApiOperation(value = "系统登录")
    @ApiOperationSupport(order = 2)
    @ApiLog(module = "系统管理", func = "身份认证", remark = "用户名密码登录", action = ApiLogAction.LOGIN)
    public Result<String> login(@Validated @RequestBody final SysLoginParam sysLoginParam) {
        final SysLoginDto sysLoginDto = sysLoginMapper.paramToDto(sysLoginParam);
        // 设置登录IP地址。
        sysLoginDto.setIp(getRequestIp());
        final String accessToken = sysLoginService.login(sysLoginDto);
        return DefaultResultFactory.success("登录成功。", accessToken);
    }

    /**
     * @return 获取当前登录人。
     */
    @GetMapping("/v1/current-user")
    @ApiOperation(value = "获取当前登录人")
    @ApiOperationSupport(order = 3)
    @ApiLog(module = "系统管理", func = "身份认证", remark = "获取当前登录人", action = ApiLogAction.QUERY)
    public Result<CurrentUser> getCurrentUser() {
        final CurrentUser saTokenUser = sysLoginService.getCurrentUser();
        return DefaultResultFactory.success("获取当前登录人", saTokenUser);
    }

    /**
     * 系统登出。
     *
     * @return 是否登出成功。
     */
    @PostMapping("/v1/logout")
    @ApiOperation(value = "系统登出")
    @ApiOperationSupport(order = 4)
    @ApiLog(module = "系统管理", func = "身份认证", remark = "系统登出", action = ApiLogAction.LOGOUT)
    public Result<Boolean> logout() {
        sysLoginService.logout();
        return DefaultResultFactory.success("登录成功。", Boolean.TRUE);
    }

    /**
     * 自动装配系统身份认证的业务处理接口。
     *
     * @param sysLoginService 系统身份认证的业务处理接口。
     */
    @Autowired
    public void setSysLoginService(SysLoginService sysLoginService) {
        this.sysLoginService = sysLoginService;
    }

    /**
     * 自动装配系统登录对象转换接口。
     *
     * @param sysLoginMapper 系统登录对象转换接口。
     */
    @Autowired
    public void setSysLoginMapper(SysLoginMapper sysLoginMapper) {
        this.sysLoginMapper = sysLoginMapper;
    }

    /**
     * 系统身份认证的业务处理接口。
     */
    private SysLoginService sysLoginService;

    /**
     * 系统登录对象转换接口。
     */
    private SysLoginMapper sysLoginMapper;

}
