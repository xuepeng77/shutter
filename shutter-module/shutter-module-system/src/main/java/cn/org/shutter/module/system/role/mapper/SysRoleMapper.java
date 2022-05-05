package cn.org.shutter.module.system.role.mapper;

import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.core.web.auth.CurrentUserRole;
import cn.org.shutter.module.system.role.dto.SysRoleDto;
import cn.org.shutter.module.system.role.entity.SysRole;
import cn.org.shutter.module.system.role.param.SysRoleParam;
import cn.org.shutter.module.system.role.vo.SysRoleVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 系统角色对象转换接口。
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysRoleMapper {

    /**
     * Param转换成Dto。
     *
     * @param sysRoleParam 系统角色的请求对象。
     * @return 系统角色的数据传输对象。
     */
    SysRoleDto paramToDto(final SysRoleParam sysRoleParam);

    /**
     * Dto转换成Entity。
     *
     * @param sysRoleDto 系统角色的数据传输对象。
     * @return 系统角色的实体对象。
     */
    SysRole dtoToEntity(final SysRoleDto sysRoleDto);

    /**
     * Entity转换成Dto。
     *
     * @param sysRole 系统角色的实体对象。
     * @return 系统角色的数据传输对象。
     */
    SysRoleDto entityToDto(final SysRole sysRole);

    /**
     * Dto转换成Vo。
     *
     * @param sysRoleDto 系统角色的数据传输对象。
     * @return 系统角色的的响应对象。
     */
    SysRoleVo dtoToVo(final SysRoleDto sysRoleDto);

    /**
     * Entity集合转换成Dto集合。
     *
     * @param sysRoleList 系统角色的实体对象集合。
     * @return 系统角色的数据传输对象集合。
     */
    List<SysRoleDto> entityListToDtoList(final List<SysRole> sysRoleList);

    /**
     * Entity分页转换成Dto分页。
     *
     * @param sysRolePage 系统角色的实体分页对象。
     * @return 系统角色的数据传输分页对象。
     */
    PageVo<SysRoleDto> entityPageToDtoPage(final Page<SysRole> sysRolePage);

    /**
     * Dto分页转换成Vo分页。
     *
     * @param sysRoleDtoPage 系统角色的数据传输分页对象。
     * @return 系统角色的响应分页对象。
     */
    PageVo<SysRoleVo> dtoPageToVoPage(final PageVo<SysRoleDto> sysRoleDtoPage);

    /**
     * Dto集合转换成CurrentUserRole集合。
     *
     * @param sysRoleDtoList 系统角色的数据传输对象集合。
     * @return CurrentUserRole集合。
     */
    List<CurrentUserRole> dtoListToCurrentUserRoleList(final List<SysRoleDto> sysRoleDtoList);

}
