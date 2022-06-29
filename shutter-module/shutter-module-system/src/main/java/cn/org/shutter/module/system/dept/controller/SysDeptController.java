package cn.org.shutter.module.system.dept.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.org.shutter.core.common.api.DefaultResultFactory;
import cn.org.shutter.core.common.api.Result;
import cn.org.shutter.core.common.bean.param.BaseParam;
import cn.org.shutter.core.web.auth.CreateUser;
import cn.org.shutter.core.web.auth.ModifyUser;
import cn.org.shutter.core.web.bean.BaseController;
import cn.org.shutter.core.web.log.ApiLog;
import cn.org.shutter.core.web.log.ApiLogAction;
import cn.org.shutter.module.system.dept.dto.SysDeptDto;
import cn.org.shutter.module.system.dept.param.SysDeptParam;
import cn.org.shutter.module.system.dept.service.SysDeptService;
import cn.org.shutter.module.system.dept.vo.SysDeptVo;
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
 * 系统组织机构的API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/depts")
@Slf4j
@Validated
@SaCheckLogin
@Api(tags = "系统组织机构的API")
@ApiSupport(order = 5)
public class SysDeptController extends BaseController {

    /**
     * 创建系统组织机构。
     *
     * @param sysDeptParam 系统组织机构的请求对象。
     * @return 是否创建成功。
     */
    @PostMapping("/v1")
    @ApiOperation(value = "创建系统组织机构")
    @ApiOperationSupport(order = 1)
    @ApiLog(module = "系统管理", func = "系统组织机构管理", remark = "创建系统组织机构", action = ApiLogAction.CREATE)
    @CreateUser
    // TODO 校验参数唯一性
    public Result<Boolean> create(@Validated(BaseParam.create.class) @RequestBody final SysDeptParam sysDeptParam) {
        final SysDeptDto sysDeptDto = sysDeptService.getSysDeptMapper().paramToDto(sysDeptParam);
        final boolean result = sysDeptService.create(sysDeptDto);
        if (result) {
            return DefaultResultFactory.success("创建系统组织机构成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("创建系统组织机构失败。", Boolean.FALSE);
    }

    /**
     * 修改系统组织机构。
     *
     * @param id           系统组织机构的主键。
     * @param sysDeptParam 系统组织机构的请求对象。
     * @return 是否修改成功。
     */
    @PutMapping("/v1/{id}")
    @ApiOperation(value = "修改系统组织机构")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统组织机构的主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统组织机构管理", remark = "修改系统组织机构", action = ApiLogAction.UPDATE)
    @ModifyUser
    // TODO 校验参数唯一性
    public Result<Boolean> update(
            @PathVariable(value = "id") final long id,
            @Validated(BaseParam.create.class) @RequestBody final SysDeptParam sysDeptParam
    ) {
        final SysDeptDto sysDeptDto = sysDeptService.getSysDeptMapper().paramToDto(sysDeptParam);
        sysDeptDto.setId(id);
        final boolean result = sysDeptService.update(sysDeptDto);
        if (result) {
            return DefaultResultFactory.success("修改系统组织机构成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("修改系统组织机构失败。", Boolean.FALSE);
    }

    /**
     * 根据主键删除系统组织机构。
     *
     * @param id 系统组织机构的主键。
     * @return 是否删除成功。
     */
    @DeleteMapping("/v1/{id}")
    @ApiOperation(value = "删除系统组织机构")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统组织机构的主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统组织机构管理", remark = "删除系统组织机构", action = ApiLogAction.DELETE)
    public Result<Boolean> deleteById(@PathVariable(value = "id") final long id) {
        final boolean result = sysDeptService.delete(id);
        if (result) {
            return DefaultResultFactory.success("删除系统组织机构成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("删除系统组织机构失败。", Boolean.FALSE);
    }

    /**
     * 根据主键停用系统组织机构。
     *
     * @param id 系统组织机构的主键。
     * @return 是否停用成功。
     */
    @PutMapping("/v1/{id}/disable")
    @ApiOperation(value = "停用系统组织机构")
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统组织机构的主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统组织机构管理", remark = "停用系统组织机构", action = ApiLogAction.CHANGE)
    public Result<Boolean> disable(@PathVariable(value = "id") final long id) {
        final boolean result = sysDeptService.disable(id);
        if (result) {
            return DefaultResultFactory.success("停用系统组织机构成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("停用系统组织机构失败。", Boolean.FALSE);
    }

    /**
     * 根据主键启用系统组织机构。
     *
     * @param id 系统组织机构的主键。
     * @return 是否启用成功。
     */
    @PutMapping("/v1/{id}/enable")
    @ApiOperation(value = "启用系统组织机构")
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统组织机构的主键", dataTypeClass = Long.class, required = true)
    )
    @ApiLog(module = "系统管理", func = "系统组织机构管理", remark = "启用系统组织机构", action = ApiLogAction.CHANGE)
    public Result<Boolean> enable(@PathVariable(value = "id") final long id) {
        final boolean result = sysDeptService.enable(id);
        if (result) {
            return DefaultResultFactory.success("启用系统组织机构成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("启用系统组织机构失败。", Boolean.FALSE);
    }

    /**
     * 根据主键查询系统组织机构。
     *
     * @param id 系统组织机构的主键。
     * @return 系统组织机构的响应对象。
     */
    @GetMapping("/v1/{id}")
    @ApiOperation(value = "查询系统组织机构")
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "系统组织机构的主键", dataTypeClass = Long.class, required = true)
    })
    @ApiLog(module = "系统管理", func = "系统组织机构管理", remark = "查询系统组织机构", action = ApiLogAction.DETAIL)
    public Result<SysDeptVo> findById(@PathVariable(value = "id") final long id) {
        final SysDeptDto sysDeptDto = sysDeptService.findById(id);
        final SysDeptVo result = sysDeptService.getSysDeptMapper().dtoToVo(sysDeptDto);
        return DefaultResultFactory.success("查询系统组织机构。", result);
    }

    /**
     * @return 查询全部系统组织机构。
     */
    @GetMapping("/v1")
    @ApiOperation(value = "查询全部系统组织机构")
    @ApiOperationSupport(order = 7)
    @ApiLog(module = "系统管理", func = "系统组织机构管理", remark = "查询全部系统组织机构", action = ApiLogAction.TREE)
    public Result<List<SysDeptVo>> tree() {
        final List<SysDeptDto> sysDeptDtos = sysDeptService.findAllToTree();
        final List<SysDeptVo> result = sysDeptService.getSysDeptMapper().dtoListToVoList(sysDeptDtos);
        return DefaultResultFactory.success("查询全部系统组织机构成功。", result);
    }

    /**
     * 自动装配系统组织机构的业务处理接口。
     *
     * @param sysDeptService 系统组织机构的业务处理接口。
     */
    @Autowired
    public void setSysDeptService(SysDeptService sysDeptService) {
        this.sysDeptService = sysDeptService;
    }

    /**
     * 系统组织机构的业务处理接口。
     */
    private SysDeptService sysDeptService;

}
