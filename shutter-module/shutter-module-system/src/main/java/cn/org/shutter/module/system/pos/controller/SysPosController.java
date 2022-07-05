package cn.org.shutter.module.system.pos.controller;

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
import cn.org.shutter.module.system.pos.dto.SysPosDto;
import cn.org.shutter.module.system.pos.param.SysPosParam;
import cn.org.shutter.module.system.pos.service.SysPosService;
import cn.org.shutter.module.system.pos.vo.SysPosVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

/**
 * 系统岗位的API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/positions")
@Slf4j
@Validated
@SaCheckLogin
@Api(tags = "系统岗位的API")
@ApiSupport(order = 6)
public class SysPosController extends BaseController {

    /**
     * 创建系统岗位。
     *
     * @param sysPosParam 系统岗位的请求对象。
     * @return 是否创建成功。
     */
    @PostMapping("/v1")
    @ApiOperation(value = "创建系统岗位")
    @ApiOperationSupport(order = 1)
    @ApiLog(module = "系统管理", func = "系统岗位管理", remark = "创建系统岗位", action = ApiLogAction.CREATE)
    @CreateUser
    // TODO 校验参数唯一性
    public Result<Boolean> create(@Validated(BaseParam.create.class) @RequestBody final SysPosParam sysPosParam) {
        final SysPosDto sysPosDto = sysPosService.getSysPosMapper().paramToDto(sysPosParam);
        final boolean result = sysPosService.create(sysPosDto);
        if (result) {
            return DefaultResultFactory.success("创建系统岗位成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("创建系统岗位失败。", Boolean.FALSE);
    }

    /**
     * 修改系统岗位。
     *
     * @param id          系统岗位的主键。
     * @param sysPosParam 系统岗位的请求对象。
     * @return 是否修改成功。
     */
    @PutMapping("/v1/{id}")
    @ApiOperation(value = "修改系统岗位")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统岗位的主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统岗位管理", remark = "修改系统岗位", action = ApiLogAction.UPDATE)
    @ModifyUser
    // TODO 校验参数唯一性
    public Result<Boolean> update(
            @PathVariable(value = "id") final long id,
            @Validated(BaseParam.create.class) @RequestBody final SysPosParam sysPosParam
    ) {
        final SysPosDto sysPosDto = sysPosService.getSysPosMapper().paramToDto(sysPosParam);
        sysPosDto.setId(id);
        final boolean result = sysPosService.update(sysPosDto);
        if (result) {
            return DefaultResultFactory.success("修改系统岗位成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("修改系统岗位失败。", Boolean.FALSE);
    }

    /**
     * 根据主键删除系统岗位。
     *
     * @param id 系统岗位的主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/{id}")
    @ApiOperation(value = "删除系统岗位")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统岗位的主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统岗位管理", remark = "删除系统岗位", action = ApiLogAction.DELETE)
    public Result<Boolean> deleteById(@PathVariable(value = "id") final long id) {
        final boolean result = sysPosService.delete(id);
        if (result) {
            return DefaultResultFactory.success("删除系统岗位成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("删除系统岗位失败。", Boolean.FALSE);
    }

    /**
     * 根据主键停用系统岗位。
     *
     * @param id 系统岗位的主键。
     * @return 是否停用成功。
     */
    @PutMapping("/v1/{id}/disable")
    @ApiOperation(value = "停用系统岗位")
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统岗位的主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统岗位管理", remark = "停用系统岗位", action = ApiLogAction.CHANGE)
    public Result<Boolean> disable(@PathVariable(value = "id") final long id) {
        final boolean result = sysPosService.disable(id);
        if (result) {
            return DefaultResultFactory.success("停用系统岗位成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("停用系统岗位失败。", Boolean.FALSE);
    }

    /**
     * 根据主键启用系统岗位。
     *
     * @param id 系统岗位的主键。
     * @return 是否启用成功。
     */
    @PutMapping("/v1/{id}/enable")
    @ApiOperation(value = "启用系统岗位")
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统岗位的主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统岗位管理", remark = "启用系统岗位", action = ApiLogAction.CHANGE)
    public Result<Boolean> enable(@PathVariable(value = "id") final long id) {
        final boolean result = sysPosService.enable(id);
        if (result) {
            return DefaultResultFactory.success("启用系统岗位成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("启用系统岗位失败。", Boolean.FALSE);
    }

    /**
     * 根据主键查询系统岗位。
     *
     * @param id 系统岗位的主键。
     * @return 系统岗位的响应对象。
     */
    @GetMapping("/v1/{id}")
    @ApiOperation(value = "查询系统岗位")
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统岗位的主键", dataTypeClass = Long.class, required = true)
    })
    @ApiLog(module = "系统管理", func = "系统岗位管理", remark = "查询系统岗位", action = ApiLogAction.DETAIL)
    public Result<SysPosVo> findById(@PathVariable(value = "id") final long id) {
        final SysPosDto sysPosDto = sysPosService.findById(id);
        final SysPosVo result = sysPosService.getSysPosMapper().dtoToVo(sysPosDto);
        return DefaultResultFactory.success("查询系统岗位。", result);
    }

    /**
     * 根据条件分页查询系统岗位。
     *
     * @param sysPosParam 查询条件对象。
     * @return 系统岗位的响应对象集合。
     */
    @GetMapping("/v1")
    @ApiOperation(value = "分页查询系统岗位")
    @ApiOperationSupport(order = 9)
    @ApiLog(module = "系统管理", func = "系统岗位管理", remark = "分页查询系统岗位", action = ApiLogAction.QUERY)
    public Result<PageVo<SysPosVo>> pageByCondition(
            @Validated(BaseParam.page.class) final SysPosParam sysPosParam
    ) {
        final SysPosDto sysPosDto = sysPosService.getSysPosMapper().paramToDto(sysPosParam);
        final Page<SysPosDto> posDtoPage = sysPosService.pageByCondition(sysPosDto);
        final PageVo<SysPosVo> result = sysPosService.getSysPosMapper().dtoPageToVoPage(posDtoPage);
        return DefaultResultFactory.success("分页查询系统岗位。", result);
    }

    /**
     * 自动装配系统岗位的业务处理接口。
     *
     * @param sysPosService 系统岗位的业务处理接口。
     */
    @Autowired
    public void setSysPosService(SysPosService sysPosService) {
        this.sysPosService = sysPosService;
    }

    /**
     * 系统岗位的业务处理接口。
     */
    private SysPosService sysPosService;

}
