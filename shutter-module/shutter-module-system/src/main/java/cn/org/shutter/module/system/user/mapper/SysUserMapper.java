package cn.org.shutter.module.system.user.mapper;

import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.core.web.auth.CurrentUser;
import cn.org.shutter.module.system.user.dto.SysUserDto;
import cn.org.shutter.module.system.user.entity.SysUser;
import cn.org.shutter.module.system.user.param.SysUserParam;
import cn.org.shutter.module.system.user.vo.SysUserVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;

/**
 * 系统用户对象转换接口。
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysUserMapper {

    /**
     * Param转换成Dto。
     *
     * @param sysUserParam 系统用户的请求对象。
     * @return 系统用户的数据传输对象。
     */
    SysUserDto paramToDto(final SysUserParam sysUserParam);

    /**
     * Dto转换成Entity。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return 系统用户的实体对象。
     */
    SysUser dtoToEntity(final SysUserDto sysUserDto);

    /**
     * Entity转换成Dto。
     *
     * @param sysUser 系统用户的实体对象。
     * @return 系统用户的数据传输对象。
     */
    SysUserDto entityToDto(final SysUser sysUser);

    /**
     * Dto转换成Vo。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return 系统用户的响应对象。
     */
    SysUserVo dtoToVo(final SysUserDto sysUserDto);

    /**
     * Entity分页转换成Dto分页。
     *
     * @param sysUserPage 系统用户的实体分页对象。
     * @return 系统用户的数据传输分页对象。
     */
    Page<SysUserDto> entityPageToDtoPage(final Page<SysUser> sysUserPage);

    /**
     * Dto分页转换成Vo分页。
     *
     * @param sysUserDtoPage 系统用户的数据传输分页对象。
     * @return 系统用户的响应分页对象。
     */
    PageVo<SysUserVo> dtoPageToVoPage(final Page<SysUserDto> sysUserDtoPage);

    /**
     * Dto转换成CurrentUser。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return CurrentUser对象。
     */
    CurrentUser dtoToCurrentUser(final SysUserDto sysUserDto);

}
