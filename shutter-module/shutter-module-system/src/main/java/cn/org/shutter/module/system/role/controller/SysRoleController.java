package cn.org.shutter.module.system.role.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.org.shutter.core.common.api.DefaultResultFactory;
import cn.org.shutter.core.common.api.Result;
import cn.org.shutter.core.common.bean.param.BaseParam;
import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.core.web.auth.CreateUser;
import cn.org.shutter.core.web.auth.ModifyUser;
import cn.org.shutter.core.web.log.ApiLog;
import cn.org.shutter.core.web.log.ApiLogAction;
import cn.org.shutter.module.system.role.dto.SysRoleDto;
import cn.org.shutter.module.system.role.param.SysRoleParam;
import cn.org.shutter.module.system.role.service.SysRoleService;
import cn.org.shutter.module.system.role.vo.SysRoleVo;
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
 * 系统角色的API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/roles")
@Slf4j
@Validated
@SaCheckLogin
@Api(tags = "系统角色的API")
@ApiSupport(order = 3)
public class SysRoleController {

    /**
     * 创建系统角色。
     *
     * @param sysRoleParam 系统角色的请求对象。
     * @return 是否创建成功。
     */
    @PostMapping("/v1")
    @ApiOperation(value = "创建系统角色")
    @ApiOperationSupport(order = 1)
    @ApiLog(module = "系统管理", func = "系统角色管理", remark = "创建系统角色", action = ApiLogAction.CREATE)
    @CreateUser
    // TODO 校验参数唯一性
    public Result<Boolean> create(@Validated(BaseParam.create.class) @RequestBody final SysRoleParam sysRoleParam) {
        final SysRoleDto sysRoleDto = sysRoleService.getSysRoleMapper().paramToDto(sysRoleParam);
        final boolean result = sysRoleService.create(sysRoleDto);
        if (result) {
            return DefaultResultFactory.success("创建系统角色成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("创建系统角色失败。", Boolean.FALSE);
    }

    /**
     * 修改系统角色。
     *
     * @param id           系统角色主键。
     * @param sysRoleParam 系统角色的请求对象。
     * @return 是否修改成功。
     */
    @PutMapping("/v1/{id}")
    @ApiOperation(value = "修改系统角色")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "删除系统角色", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统角色管理", remark = "修改系统角色", action = ApiLogAction.UPDATE)
    @ModifyUser
    // TODO 校验参数唯一性
    public Result<Boolean> update(
            @PathVariable(value = "id") final long id,
            @Validated(BaseParam.update.class) @RequestBody final SysRoleParam sysRoleParam) {
        final SysRoleDto sysRoleDto = sysRoleService.getSysRoleMapper().paramToDto(sysRoleParam);
        sysRoleDto.setId(id);
        final boolean result = sysRoleService.update(sysRoleDto);
        if (result) {
            return DefaultResultFactory.success("修改系统角色成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("修改系统角色失败。", Boolean.FALSE);
    }

    /**
     * 根据主键删除系统角色。
     *
     * @param id 系统角色主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/{id}")
    @ApiOperation(value = "删除系统角色")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "删除系统角色", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统角色管理", remark = "删除系统角色", action = ApiLogAction.DELETE)
    public Result<Boolean> deleteById(@PathVariable(value = "id") final long id) {
        final boolean result = sysRoleService.delete(id);
        if (result) {
            return DefaultResultFactory.success("删除系统角色成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("删除系统角色失败。", Boolean.FALSE);
    }

    /**
     * 根据主键批量删除系统角色。
     *
     * @param ids 系统角色主键集合。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1")
    @ApiOperation(value = "批量删除系统角色")
    @ApiOperationSupport(order = 4)
    @ApiLog(module = "系统管理", func = "系统角色管理", remark = "批量删除系统角色", action = ApiLogAction.DELETE)
    public Result<Boolean> deleteByIds(@RequestBody final List<Long> ids) {
        final boolean result = sysRoleService.deleteBatch(ids);
        if (result) {
            return DefaultResultFactory.success("批量删除系统角色成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("批量删除系统角色失败。", Boolean.FALSE);
    }

    /**
     * 根据主键停用系统角色。
     *
     * @param id 系统角色主键。
     * @return 是否停用成功。
     */
    @PutMapping("/v1/{id}/disable")
    @ApiOperation(value = "停用系统角色")
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统角色主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统角色管理", remark = "停用系统角色", action = ApiLogAction.CHANGE)
    public Result<Boolean> disable(@PathVariable(value = "id") final long id) {
        final boolean result = sysRoleService.disable(id);
        if (result) {
            return DefaultResultFactory.success("停用系统角色成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("停用系统角色失败。", Boolean.FALSE);
    }

    /**
     * 根据主键启用系统角色。
     *
     * @param id 系统角色主键。
     * @return 是否启用成功。
     */
    @PutMapping("/v1/{id}/enable")
    @ApiOperation(value = "启用系统角色")
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统角色主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统角色管理", remark = "启用系统角色", action = ApiLogAction.CHANGE)
    public Result<Boolean> enable(@PathVariable(value = "id") final long id) {
        final boolean result = sysRoleService.enable(id);
        if (result) {
            return DefaultResultFactory.success("启用系统角色成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("启用系统角色失败。", Boolean.FALSE);
    }

    /**
     * 根据主键查询系统角色。
     *
     * @param id 系统角色主键。
     * @return 系统角色的响应对象。
     */
    @GetMapping("/v1/{id}")
    @ApiOperation(value = "查询系统角色")
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统主键", dataTypeClass = Long.class, required = true)
    })
    @ApiLog(module = "系统管理", func = "系统角色管理", remark = "查询系统角色", action = ApiLogAction.DETAIL)
    public Result<SysRoleVo> findById(@PathVariable(value = "id") final long id) {
        final SysRoleDto sysRoleDto = sysRoleService.findById(id);
        final SysRoleVo result = sysRoleService.getSysRoleMapper().dtoToVo(sysRoleDto);
        return DefaultResultFactory.success("查询系统角色。", result);
    }

    /**
     * 根据条件分页查询系统角色。
     *
     * @param sysRoleParam 查询条件对象。
     * @return 系统角色的响应对象集合。
     */
    @GetMapping("/v1")
    @ApiOperation(value = "分页查询系统角色")
    @ApiOperationSupport(order = 8)
    @ApiLog(module = "系统管理", func = "系统角色管理", remark = "分页查询系统角色", action = ApiLogAction.QUERY)
    public Result<PageVo<SysRoleVo>> pageByCondition(
            @Validated(BaseParam.page.class) final SysRoleParam sysRoleParam
    ) {
        final SysRoleDto sysRoleDto = sysRoleService.getSysRoleMapper().paramToDto(sysRoleParam);
        final PageVo<SysRoleDto> roleDtoPage = sysRoleService.pageByCondition(sysRoleDto);
        final PageVo<SysRoleVo> result = sysRoleService.getSysRoleMapper().dtoPageToVoPage(roleDtoPage);
        return DefaultResultFactory.success("分页查询系统角色。", result);
    }

    /**
     * 自动装配系统角色的业务处理接口。
     *
     * @param sysRoleService 系统角色的业务处理接口。
     */
    @Autowired
    public void setSysRoleService(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    /**
     * 系统角色的业务处理接口。
     */
    private SysRoleService sysRoleService;

}
