package cn.org.niubility.shutter.module.system.user.controller;

import cn.org.niubility.shutter.core.common.bean.api.DefaultResultFactory;
import cn.org.niubility.shutter.core.common.bean.api.Result;
import cn.org.niubility.shutter.core.web.bean.BaseController;
import cn.org.niubility.shutter.module.system.user.dto.SysUserDto;
import cn.org.niubility.shutter.module.system.user.service.SysUserService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统用户的API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/users")
@Slf4j
@Api(tags = "系统用户API")
@ApiSupport(order = 1)
public class SysUserController extends BaseController {

    @GetMapping("/v1/{id}")
    public Result<SysUserDto> findById(@PathVariable(value = "id") final long id) {
        final SysUserDto result = sysUserService.findById(id);
        return DefaultResultFactory.success("success", result);
    }

    @Autowired
    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    private SysUserService sysUserService;

}
