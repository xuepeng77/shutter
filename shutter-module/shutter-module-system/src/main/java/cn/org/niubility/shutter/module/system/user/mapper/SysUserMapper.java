package cn.org.niubility.shutter.module.system.user.mapper;

import cn.org.niubility.shutter.module.system.user.dto.SysUserDto;
import cn.org.niubility.shutter.module.system.user.entity.SysUser;
import org.mapstruct.Mapper;

/**
 * 系统用户对象转换接口。
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysUserMapper {

    /**
     * Entity转换成Dto。
     *
     * @param sysUser 系统用户实体对象。
     * @return 系统用户数据传输对象。
     */
    SysUserDto toDto(final SysUser sysUser);

    /**
     * Dto转换成Entity。
     *
     * @param sysUserDto 系统用户数据传输对象。
     * @return 系统用户实体对象。
     */
    SysUser toEntity(final SysUserDto sysUserDto);

}
