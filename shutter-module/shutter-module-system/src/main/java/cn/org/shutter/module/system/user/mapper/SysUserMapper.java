package cn.org.shutter.module.system.user.mapper;

import cn.org.shutter.module.system.user.dto.SysUserDto;
import cn.org.shutter.module.system.user.entity.SysUser;
import cn.org.shutter.module.system.user.vo.SysUserRequestVo;
import cn.org.shutter.module.system.user.vo.SysUserResponseVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 系统用户对象转换接口。
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysUserMapper {

    /**
     * Vo转换成Dto。
     *
     * @param sysUserRequestVo 系统用户的请求对象。
     * @return 系统用户数据传输对象。
     */
    @Mapping(target = "password", ignore = true)
    SysUserDto voToDto(final SysUserRequestVo sysUserRequestVo);

    /**
     * Dto转换成Entity。
     *
     * @param sysUserDto 系统用户数据传输对象。
     * @return 系统用户实体对象。
     */
    SysUser dtoToEntity(final SysUserDto sysUserDto);

    /**
     * Entity转换成Dto。
     *
     * @param sysUser 系统用户实体对象。
     * @return 系统用户数据传输对象。
     */
    SysUserDto entityToDto(final SysUser sysUser);

    /**
     * Dto转换成Vo。
     *
     * @param sysUserDto 系统用户数据传输对象。
     * @return 系统用户的响应对象。
     */
    SysUserResponseVo dtoToVo(final SysUserDto sysUserDto);

}
