package cn.org.niubility.shutter.module.system.user.controller;

import cn.org.niubility.shutter.core.common.bean.api.DefaultResultFactory;
import cn.org.niubility.shutter.core.common.bean.api.Result;
import cn.org.niubility.shutter.core.web.bean.BaseController;
import cn.org.niubility.shutter.core.web.log.ApiLog;
import cn.org.niubility.shutter.core.web.log.ApiLogAction;
import cn.org.niubility.shutter.module.system.user.dto.SysUserDto;
import cn.org.niubility.shutter.module.system.user.mapper.SysUserMapper;
import cn.org.niubility.shutter.module.system.user.service.SysUserService;
import cn.org.niubility.shutter.module.system.user.vo.SysUserRequest;
import cn.org.niubility.shutter.module.system.user.vo.SysUserResponse;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 系统用户的API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/users")
@Slf4j
@Api(tags = "系统用户的API")
@ApiSupport(order = 1)
public class SysUserController extends BaseController {

    /**
     * 创建系统用户。
     *
     * @param sysUserRequest 系统用户的请求类。
     * @return 是否创建成功。
     */
    @PostMapping("/v1")
    @ApiOperation(value = "创建系统用户")
    @ApiOperationSupport(order = 1)
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "创建系统用户", action = ApiLogAction.CREATE)
    public Result<Boolean> create(@Valid @RequestBody final SysUserRequest sysUserRequest) {
        final SysUserDto sysUserDto = sysUserMapper.requestToDto(sysUserRequest);
        final boolean result = sysUserService.create(sysUserDto);
        if (result) {
            return DefaultResultFactory.success("创建系统用户成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("创建系统用户失败。", Boolean.TRUE);
    }

    /**
     * 根据主键查询系统用户。
     *
     * @param id 主键。
     * @return 系统用户。
     */
    @GetMapping("/v1/{id}")
    @ApiOperation(value = "根据主键查询系统用户")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统主键", dataTypeClass = Long.class, required = true)
    })
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "根据主键查询系统用户", action = ApiLogAction.QUERY)
    public Result<SysUserResponse> findById(@PathVariable(value = "id") final long id) {
        final SysUserDto sysUserDto = sysUserService.findById(id);
        final SysUserResponse result = sysUserMapper.dtoToResponse(sysUserDto);
        return DefaultResultFactory.success("根据主键查询系统用户。", result);
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
     * 自动装配系统用户对象转换接口。
     *
     * @param sysUserMapper 系统用户对象转换接口。
     */
    @Autowired
    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 系统用户的业务处理接口。
     */
    private SysUserService sysUserService;

    /**
     * 系统用户对象转换接口。
     */
    private SysUserMapper sysUserMapper;

}
