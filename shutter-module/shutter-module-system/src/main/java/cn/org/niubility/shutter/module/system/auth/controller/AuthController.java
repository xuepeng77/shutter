package cn.org.niubility.shutter.module.system.auth.controller;

import cn.org.niubility.shutter.core.common.bean.api.DefaultResultFactory;
import cn.org.niubility.shutter.core.common.bean.api.Result;
import cn.org.niubility.shutter.core.web.bean.BaseController;
import cn.org.niubility.shutter.core.web.log.ApiLog;
import cn.org.niubility.shutter.core.web.log.ApiLogAction;
import cn.org.niubility.shutter.module.system.auth.service.AuthService;
import cn.org.niubility.shutter.module.system.auth.vo.SysLoginRequest;
import cn.org.niubility.shutter.sdk.verifycode.entity.VerifyCode;
import cn.org.niubility.shutter.sdk.verifycode.service.VerifyCodeService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
public class AuthController extends BaseController {

    /**
     * 获取登录验证码。
     *
     * @return 验证码。
     */
    @GetMapping("/v1/verify-code")
    @ApiOperation(value = "获取验证码")
    @ApiOperationSupport(order = 1)
    @ApiLog(module = "身份认证", func = "系统登录", remark = "获取验证码", action = ApiLogAction.CREATE)
    public Result<VerifyCode> createVerifyCode() {
        final VerifyCode result = imageVerifyCodeService.send(StringUtils.EMPTY);
        return DefaultResultFactory.success("获取验证码成功。", result);
    }

    /**
     * 系统登录。
     *
     * @param sysLoginRequest 系统登录的请求对象。
     * @return 是否登录成功。
     */
    @PostMapping("/v1/login")
    @ApiOperation(value = "系统登录")
    @ApiOperationSupport(order = 2)
    @ApiLog(module = "身份认证", func = "系统登录", remark = "用户名密码登录", action = ApiLogAction.LOGIN)
    public Result<Boolean> login(@Valid @RequestBody final SysLoginRequest sysLoginRequest) {
        authService.login(
                sysLoginRequest.getAccount(),
                sysLoginRequest.getPassword(),
                getRequestIp()
        );
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
        authService.logout();
        return DefaultResultFactory.success("登录成功。", Boolean.TRUE);
    }

    /**
     * 自动装配系统身份认证的业务处理接口。
     *
     * @param authService 系统身份认证的业务处理接口。
     */
    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
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
     * 系统身份认证的业务处理接口。
     */
    private AuthService authService;

    /**
     * 验证码的业务处理接口。
     */
    private VerifyCodeService imageVerifyCodeService;

}
