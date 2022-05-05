package cn.org.shutter.module.system.func.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.org.shutter.core.common.api.DefaultResultFactory;
import cn.org.shutter.core.common.api.Result;
import cn.org.shutter.core.common.bean.param.BaseParam;
import cn.org.shutter.core.web.auth.CreateUser;
import cn.org.shutter.core.web.log.ApiLog;
import cn.org.shutter.core.web.log.ApiLogAction;
import cn.org.shutter.module.system.func.dto.SysFuncDto;
import cn.org.shutter.module.system.func.param.SysFuncParam;
import cn.org.shutter.module.system.func.service.SysFuncService;
import cn.org.shutter.module.system.func.vo.SysFuncVo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统功能的API。
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/funcs")
@Slf4j
@Validated
@SaCheckLogin
@Api(tags = "系统功能的API")
@ApiSupport(order = 4)
public class SysFuncController {


    @PostMapping("/v1")
    @ApiOperation(value = "创建系统功能")
    @ApiOperationSupport(order = 1)
    @ApiLog(module = "系统管理", func = "系统功能管理", remark = "创建系统功能", action = ApiLogAction.CREATE)
    @CreateUser
    // TODO 校验参数唯一性
    public Result<Boolean> create(@Validated(BaseParam.create.class) @RequestBody final SysFuncParam sysFuncParam) {
        final SysFuncDto sysFuncDto = sysFuncService.getSysFuncMapper().paramToDto(sysFuncParam);
        final boolean result = sysFuncService.create(sysFuncDto);
        if (result) {
            return DefaultResultFactory.success("创建系统功能成功。", Boolean.TRUE);
        }
        return DefaultResultFactory.fail("创建系统功能失败。", Boolean.FALSE);
    }

    /**
     * @return 查询全部系统功能。
     */
    @GetMapping("/v1")
    @ApiOperation(value = "查询全部系统功能")
    @ApiOperationSupport(order = 99)
    @ApiLog(module = "系统管理", func = "系统功能管理", remark = "查询全部系统功能", action = ApiLogAction.QUERY)
    public Result<List<SysFuncVo>> findAll() {
        final List<SysFuncDto> sysFuncDtos = sysFuncService.findAllToTree();
        final List<SysFuncVo> result = sysFuncService.getSysFuncMapper().dtoListToVoList(sysFuncDtos);
        return DefaultResultFactory.success("查询全部系统功能成功。", result);
    }

    /**
     * 自动装配系统功能的业务处理接口。
     *
     * @param sysFuncService 系统功能的业务处理接口。
     */
    @Autowired
    public void setSysFuncService(SysFuncService sysFuncService) {
        this.sysFuncService = sysFuncService;
    }

    /**
     * 系统功能的业务处理接口。
     */
    private SysFuncService sysFuncService;

}
