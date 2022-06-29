package cn.org.shutter.module.system.dept.mapper;

import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.module.system.dept.dto.SysDeptDto;
import cn.org.shutter.module.system.dept.entity.SysDept;
import cn.org.shutter.module.system.dept.param.SysDeptParam;
import cn.org.shutter.module.system.dept.vo.SysDeptVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 系统组织机构对象转换接口。
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysDeptMapper {

    /**
     * Param转换成Dto。
     *
     * @param sysDeptParam 系统组织机构的请求对象。
     * @return 系统组织机构的数据传输对象。
     */
    SysDeptDto paramToDto(final SysDeptParam sysDeptParam);

    /**
     * Dto转换成Entity。
     *
     * @param sysDeptDto 系统组织机构的数据传输对象。
     * @return 系统组织机构的实体对象。
     */
    SysDept dtoToEntity(final SysDeptDto sysDeptDto);

    /**
     * Entity转换成Dto。
     *
     * @param sysDept 系统组织机构的实体对象。
     * @return 系统组织机构的数据传输对象。
     */
    SysDeptDto entityToDto(final SysDept sysDept);

    /**
     * Dto转换成Vo。
     *
     * @param sysDeptDto 系统组织机构的数据传输对象。
     * @return 系统组织机构的响应对象。
     */
    SysDeptVo dtoToVo(final SysDeptDto sysDeptDto);

    /**
     * Entity集合转换成Dto集合。
     *
     * @param sysDeptList 系统组织机构的实体对象集合。
     * @return 系统组织机构的数据传输对象集合。
     */
    List<SysDeptDto> entityListToDtoList(final List<SysDept> sysDeptList);

    /**
     * Dto集合转换成Vo集合。
     *
     * @param sysDeptDtoList 系统组织机构的数据传输对象集合。
     * @return 系统组织机构的响应对象集合。
     */
    List<SysDeptVo> dtoListToVoList(final List<SysDeptDto> sysDeptDtoList);

    /**
     * Entity分页转换成Dto分页。
     *
     * @param sysDeptPage 系统组织机构的实体分页对象。
     * @return 系统组织机构的数据传输分页对象。
     */
    PageVo<SysDeptDto> entityPageToDtoPage(final Page<SysDept> sysDeptPage);

    /**
     * Dto分页转换成Vo分页。
     *
     * @param sysDeptDtoPage 系统组织机构的数据传输分页对象。
     * @return 系统组织机构的响应分页对象。
     */
    PageVo<SysDeptVo> dtoPageToVoPage(final PageVo<SysDeptDto> sysDeptDtoPage);

}
