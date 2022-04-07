package cn.org.niubility.shutter.module.system.user.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.org.niubility.shutter.core.common.bean.api.DefaultResultFactory;
import cn.org.niubility.shutter.core.common.bean.api.Result;
import cn.org.niubility.shutter.core.web.auth.CreateUser;
import cn.org.niubility.shutter.core.web.auth.ModifyUser;
import cn.org.niubility.shutter.core.web.bean.BaseController;
import cn.org.niubility.shutter.core.web.log.ApiLog;
import cn.org.niubility.shutter.core.web.log.ApiLogAction;
import cn.org.niubility.shutter.module.system.user.dto.SysUserDto;
import cn.org.niubility.shutter.module.system.user.mapper.SysUserMapper;
import cn.org.niubility.shutter.module.system.user.service.SysUserService;
import cn.org.niubility.shutter.module.system.user.vo.SysUserRequestVo;
import cn.org.niubility.shutter.module.system.user.vo.SysUserResponseVo;
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
import java.util.List;

/**
 * 系统用户的API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/users")
@Slf4j
@SaCheckLogin
@Api(tags = "系统用户的API")
@ApiSupport(order = 2)
public class SysUserController extends BaseController {

    /**
     * 创建系统用户。
     *
     * @param sysUserRequestVo 系统用户的请求对象。
     * @return 是否创建成功。
     */
    @PostMapping("/v1")
    @ApiOperation(value = "创建系统用户")
    @ApiOperationSupport(order = 1)
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "创建系统用户", action = ApiLogAction.CREATE)
    @CreateUser
    public Result<Boolean> create(@Valid @RequestBody final SysUserRequestVo sysUserRequestVo) {
        final SysUserDto sysUserDto = sysUserMapper.voToDto(sysUserRequestVo);
        sysUserDto.setRegeditIp(getRequestIp());
        final boolean result = sysUserService.create(sysUserDto);
        if (result) {
            return DefaultResultFactory.success("创建系统用户成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("创建系统用户失败。", Boolean.FALSE);
    }

    /**
     * 修改系统用户。
     *
     * @param id               系统用户主键。
     * @param sysUserRequestVo 系统用户的请求对象。
     * @return 是否修改成功。
     */
    @PutMapping("/v1/{id}")
    @ApiOperation(value = "修改系统用户")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统用户主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "编辑系统用户", action = ApiLogAction.UPDATE)
    @ModifyUser
    public Result<Boolean> update(
            @PathVariable(value = "id") final long id,
            @Valid @RequestBody final SysUserRequestVo sysUserRequestVo
    ) {
        final SysUserDto sysUserDto = sysUserMapper.voToDto(sysUserRequestVo);
        sysUserDto.setId(id);
        final boolean result = sysUserService.update(sysUserDto);
        if (result) {
            return DefaultResultFactory.success("修改系统用户成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("修改系统用户失败。", Boolean.FALSE);
    }

    /**
     * 根据主键删除系统用户。
     *
     * @param id 系统用户主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/{id}")
    @ApiOperation(value = "删除系统用户")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统用户主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "删除系统用户", action = ApiLogAction.DELETE)
    public Result<Boolean> deleteById(@PathVariable(value = "id") final long id) {
        final boolean result = sysUserService.delete(id);
        if (result) {
            return DefaultResultFactory.success("删除系统用户成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("删除系统用户失败。", Boolean.FALSE);
    }

    /**
     * 根据主键批量删除系统用户。
     *
     * @param ids 系统用户主键集合。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1")
    @ApiOperation(value = "批量删除系统用户")
    @ApiOperationSupport(order = 4)
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "批量删除系统用户", action = ApiLogAction.DELETE)
    public Result<Boolean> deleteByIds(@RequestBody final List<Long> ids) {
        final boolean result = sysUserService.deleteBatch(ids);
        if (result) {
            return DefaultResultFactory.success("批量删除系统用户成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("批量删除系统用户失败。", Boolean.FALSE);
    }

    /**
     * 根据主键查询系统用户。
     *
     * @param id 系统用户主键。
     * @return 系统用户的视图对象。
     */
    @GetMapping("/v1/{id}")
    @ApiOperation(value = "根据主键查询系统用户")
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统主键", dataTypeClass = Long.class, required = true)
    })
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "根据主键查询系统用户", action = ApiLogAction.QUERY)
    public Result<SysUserResponseVo> findById(@PathVariable(value = "id") final long id) {
        final SysUserDto sysUserDto = sysUserService.findById(id);
        final SysUserResponseVo result = sysUserMapper.dtoToVo(sysUserDto);
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
