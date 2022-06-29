package cn.org.shutter.module.system.pos.mapper;

import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.module.system.pos.dto.SysPosDto;
import cn.org.shutter.module.system.pos.entity.SysPos;
import cn.org.shutter.module.system.pos.param.SysPosParam;
import cn.org.shutter.module.system.pos.vo.SysPosVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 系统岗位对象转换接口。
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysPosMapper {

    /**
     * Param转换成Dto。
     *
     * @param sysPosParam 系统岗位的请求对象。
     * @return 系统岗位的数据传输对象。
     */
    SysPosDto paramToDto(final SysPosParam sysPosParam);

    /**
     * Dto转换成Entity。
     *
     * @param sysPosDto 系统岗位的数据传输对象。
     * @return 系统岗位的实体对象。
     */
    SysPos dtoToEntity(final SysPosDto sysPosDto);

    /**
     * Entity转换成Dto。
     *
     * @param sysPos 系统岗位的实体对象。
     * @return 系统岗位的数据传输对象。
     */
    SysPosDto entityToDto(final SysPos sysPos);

    /**
     * Dto转换成Vo。
     *
     * @param sysPosDto 系统岗位的数据传输对象。
     * @return 系统岗位的响应对象。
     */
    SysPosVo dtoToVo(final SysPosDto sysPosDto);

    /**
     * Entity集合转换成Dto集合。
     *
     * @param sysPosList 系统岗位的实体对象集合。
     * @return 系统岗位的数据传输对象集合。
     */
    List<SysPosDto> entityListToDtoList(final List<SysPos> sysPosList);

    /**
     * Dto集合转换成Vo集合。
     *
     * @param sysPosDtoList 系统岗位的数据传输对象集合。
     * @return 系统岗位的响应对象集合。
     */
    List<SysPosVo> dtoListToVoList(final List<SysPosDto> sysPosDtoList);

    /**
     * Entity分页转换成Dto分页。
     *
     * @param sysPosPage 系统岗位的实体分页对象。
     * @return 系统岗位的数据传输分页对象。
     */
    PageVo<SysPosDto> entityPageToDtoPage(final Page<SysPos> sysPosPage);

    /**
     * Dto分页转换成Vo分页。
     *
     * @param sysPosDtoPage 系统岗位的数据传输分页对象。
     * @return 系统岗位的响应分页对象。
     */
    PageVo<SysPosVo> dtoPageToVoPage(final PageVo<SysPosDto> sysPosDtoPage);

}
