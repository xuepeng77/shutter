package cn.org.shutter.module.system.login.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.org.shutter.core.common.bean.api.DefaultResultFactory;
import cn.org.shutter.core.common.bean.api.Result;
import cn.org.shutter.core.web.bean.BaseController;
import cn.org.shutter.core.web.log.ApiLog;
import cn.org.shutter.core.web.log.ApiLogAction;
import cn.org.shutter.module.system.login.dto.SysLoginDto;
import cn.org.shutter.module.system.login.mapper.SysLoginMapper;
import cn.org.shutter.module.system.login.service.SysLoginService;
import cn.org.shutter.module.system.login.vo.SysLoginRequestVo;
import cn.org.shutter.sdk.verifycode.entity.VerifyCode;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @ApiLog(module = "身份认证", func = "系统登录", remark = "获取验证码", action = ApiLogAction.CREATE)
    public Result<VerifyCode> createLoginVerifyCode() {
        final VerifyCode result = sysLoginService.createLoginVerifyCode();
        return DefaultResultFactory.success("获取验证码成功。", result);
    }

    /**
     * 系统登录。
     *
     * @param sysLoginRequestVo 系统登录的请求对象。
     * @return 是否登录成功。
     */
    @PostMapping("/v1/login")
    @ApiOperation(value = "系统登录")
    @ApiOperationSupport(order = 2)
    @ApiLog(module = "身份认证", func = "系统登录", remark = "用户名密码登录", action = ApiLogAction.LOGIN)
    public Result<Boolean> login(@Valid @RequestBody final SysLoginRequestVo sysLoginRequestVo) {
        final SysLoginDto sysLoginDto = sysLoginMapper.voToDto(sysLoginRequestVo);
        // 设置登录IP地址。
        sysLoginDto.setIp(getRequestIp());
        sysLoginService.login(sysLoginDto);
        return DefaultResultFactory.success("登录成功。", Boolean.TRUE);
    }

    /**
     * 系统登出。
     *
     * @return 是否登出成功。
     */
    @PostMapping("/v1/logout")
    @ApiOperation(value = "系统登出")
    @ApiOperationSupport(order = 3)
    @ApiLog(module = "身份认证", func = "系统登出", remark = "系统登出", action = ApiLogAction.LOGOUT)
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
