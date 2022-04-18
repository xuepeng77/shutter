package cn.org.shutter.module.system.user.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.org.shutter.core.common.api.DefaultResultFactory;
import cn.org.shutter.core.common.api.Result;
import cn.org.shutter.core.common.bean.param.BaseParam;
import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.core.web.auth.CreateUser;
import cn.org.shutter.core.web.auth.ModifyUser;
import cn.org.shutter.core.web.bean.BaseController;
import cn.org.shutter.core.web.log.ApiLog;
import cn.org.shutter.core.web.log.ApiLogAction;
import cn.org.shutter.module.system.user.dto.SysUserDto;
import cn.org.shutter.module.system.user.param.SysUserParam;
import cn.org.shutter.module.system.user.service.SysUserService;
import cn.org.shutter.module.system.user.vo.SysUserVo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统用户的API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/users")
@Slf4j
@Validated
@SaCheckLogin
@Api(tags = "系统用户的API")
@ApiSupport(order = 2)
public class SysUserController extends BaseController {

    /**
     * 创建系统用户。
     *
     * @param sysUserParam 系统用户的请求对象。
     * @return 是否创建成功。
     */
    @PostMapping("/v1")
    @ApiOperation(value = "创建系统用户")
    @ApiOperationSupport(order = 1)
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "创建系统用户", action = ApiLogAction.CREATE)
    @CreateUser
    // TODO 校验参数唯一性
    public Result<Boolean> create(@Validated(BaseParam.create.class) @RequestBody final SysUserParam sysUserParam) {
        final SysUserDto sysUserDto = sysUserService.getSysUserMapper().paramToDto(sysUserParam);
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
     * @param id           系统用户主键。
     * @param sysUserParam 系统用户的请求对象。
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
    // TODO 校验参数唯一性
    public Result<Boolean> update(
            @PathVariable(value = "id") final long id,
            @Validated(BaseParam.update.class) @RequestBody final SysUserParam sysUserParam
    ) {
        final SysUserDto sysUserDto = sysUserService.getSysUserMapper().paramToDto(sysUserParam);
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
     * 根据主键停用系统用户。
     *
     * @param id 系统用户主键。
     * @return 是否停用成功。
     */
    @PutMapping("/v1/{id}/disable")
    @ApiOperation(value = "停用系统用户")
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统用户主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "停用系统用户", action = ApiLogAction.CHANGE)
    public Result<Boolean> disable(@PathVariable(value = "id") final long id) {
        final boolean result = sysUserService.disable(id);
        if (result) {
            return DefaultResultFactory.success("停用系统用户成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("停用系统用户失败。", Boolean.FALSE);
    }

    /**
     * 根据主键启用系统用户。
     *
     * @param id 系统用户主键。
     * @return 是否启用成功。
     */
    @PutMapping("/v1/{id}/enable")
    @ApiOperation(value = "启用系统用户")
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统用户主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "启用系统用户", action = ApiLogAction.CHANGE)
    public Result<Boolean> enable(@PathVariable(value = "id") final long id) {
        final boolean result = sysUserService.enable(id);
        if (result) {
            return DefaultResultFactory.success("启用系统用户成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("启用系统用户失败。", Boolean.FALSE);
    }

    /**
     * 根据主键重置系统用户的登录密码。
     *
     * @param id 系统用户主键。
     * @return 是否重置成功。
     */
    @PutMapping("/v1/{id}/reset-password")
    @ApiOperation(value = "重置登录密码")
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统用户主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "重置登录密码", action = ApiLogAction.UPDATE)
    public Result<Boolean> resetPassword(@PathVariable(value = "id") final long id) {
        final boolean result = sysUserService.resetPassword(id);
        if (result) {
            return DefaultResultFactory.success("重置密码成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("重置密码失败。", Boolean.FALSE);
    }

    /**
     * 根据主键查询系统用户。
     *
     * @param id 系统用户主键。
     * @return 系统用户的响应对象。
     */
    @GetMapping("/v1/{id}")
    @ApiOperation(value = "查询系统用户")
    @ApiOperationSupport(order = 8)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统主键", dataTypeClass = Long.class, required = true)
    })
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "查询系统用户", action = ApiLogAction.DETAIL)
    public Result<SysUserVo> findById(@PathVariable(value = "id") final long id) {
        final SysUserDto sysUserDto = sysUserService.findById(id);
        final SysUserVo result = sysUserService.getSysUserMapper().dtoToVo(sysUserDto);
        return DefaultResultFactory.success("查询系统用户。", result);
    }

    /**
     * 根据条件分页查询系统用户。
     *
     * @param sysUserParam 查询条件对象。
     * @return 系统用户的响应对象集合。
     */
    @GetMapping("/v1")
    @ApiOperation(value = "分页查询系统用户")
    @ApiOperationSupport(order = 9)
    @ApiLog(module = "系统管理", func = "系统用户管理", remark = "分页查询系统用户", action = ApiLogAction.QUERY)
    public Result<PageVo<SysUserVo>> pageByCondition(
            @Validated(BaseParam.page.class) final SysUserParam sysUserParam
    ) {
        final SysUserDto sysUserDto = sysUserService.getSysUserMapper().paramToDto(sysUserParam);
        final PageVo<SysUserDto> userDtoPage = sysUserService.pageByCondition(sysUserDto);
        final PageVo<SysUserVo> result = sysUserService.getSysUserMapper().dtoPageToVoPage(userDtoPage);
        return DefaultResultFactory.success("分页查询系统用户。", result);
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
     * 系统用户的业务处理接口。
     */
    private SysUserService sysUserService;

}
