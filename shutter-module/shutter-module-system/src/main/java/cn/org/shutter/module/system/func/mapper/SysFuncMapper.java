package cn.org.shutter.module.system.func.mapper;

import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.core.web.auth.CurrentUserFunc;
import cn.org.shutter.module.system.func.dto.SysFuncDto;
import cn.org.shutter.module.system.func.entity.SysFunc;
import cn.org.shutter.module.system.func.param.SysFuncParam;
import cn.org.shutter.module.system.func.vo.SysFuncVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * 系统功能对象转换接口。
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysFuncMapper {

    /**
     * Param转换成Dto。
     *
     * @param sysFuncParam 系统功能的请求对象。
     * @return 系统功能的数据传输对象。
     */
    SysFuncDto paramToDto(final SysFuncParam sysFuncParam);

    /**
     * Dto转换成Entity。
     *
     * @param sysFuncDto 系统功能的数据传输对象。
     * @return 系统功能的实体对象。
     */
    SysFunc dtoToEntity(final SysFuncDto sysFuncDto);

    /**
     * Entity转换成Dto。
     *
     * @param sysFunc 系统功能的实体对象。
     * @return 系统功能的数据传输对象。
     */
    SysFuncDto entityToDto(final SysFunc sysFunc);

    /**
     * Dto转换成Vo。
     *
     * @param sysFuncDto 系统功能的数据传输对象。
     * @return 系统功能的响应对象。
     */
    SysFuncVo dtoToVo(final SysFuncDto sysFuncDto);

    /**
     * Entity集合转换成Dto集合。
     *
     * @param sysFuncList 系统功能的实体对象集合。
     * @return 系统功能的数据传输对象集合。
     */
    List<SysFuncDto> entityListToDtoList(final List<SysFunc> sysFuncList);

    /**
     * Dto集合转换成Vo集合。
     *
     * @param sysFuncDtoList 系统功能的数据传输对象集合。
     * @return 系统功能的响应对象集合。
     */
    List<SysFuncVo> dtoListToVoList(final List<SysFuncDto> sysFuncDtoList);

    /**
     * Entity分页转换成Dto分页。
     *
     * @param sysFuncPage 系统功能的实体分页对象。
     * @return 系统功能的数据传输分页对象。
     */
    Page<SysFuncDto> entityPageToDtoPage(final Page<SysFunc> sysFuncPage);

    /**
     * Dto分页转换成Vo分页。
     *
     * @param sysFuncDtoPage 系统功能的数据传输分页对象。
     * @return 系统功能的响应分页对象。
     */
    PageVo<SysFuncVo> dtoPageToVoPage(final Page<SysFuncDto> sysFuncDtoPage);

    /**
     * Dto转换成CurrentUserFunc对象。
     *
     * @param sysFuncDto 系统功能的数据传输对象。
     * @return CurrentUserFunc对象。
     */
    @Mappings(@Mapping(source = "type.code", target = "type"))
    CurrentUserFunc dtoToCurrentUserFunc(final SysFuncDto sysFuncDto);

    /**
     * Dto集合转换成CurrentUserFunc集合。
     *
     * @param sysFuncDtoList 系统功能的数据传输对象集合。
     * @return CurrentUserFunc集合。
     */
    List<CurrentUserFunc> dtoListToCurrentUserFuncList(final List<SysFuncDto> sysFuncDtoList);

}
