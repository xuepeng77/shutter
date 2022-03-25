package cn.org.niubility.shutter.module.system.user.mapper;

import cn.org.niubility.shutter.module.system.user.dto.SysUserDto;
import cn.org.niubility.shutter.module.system.user.entity.SysUser;
import cn.org.niubility.shutter.module.system.user.vo.SysUserRequest;
import cn.org.niubility.shutter.module.system.user.vo.SysUserResponse;
import org.mapstruct.Mapper;

/**
 * 系统用户对象转换接口。
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysUserMapper {

    /**
     * Request转换成Dto。
     *
     * @param sysUserRequest 系统用户的请求对象。
     * @return 系统用户数据传输对象。
     */
    SysUserDto requestToDto(final SysUserRequest sysUserRequest);

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
     * Dto转换成Response。
     *
     * @param sysUserDto 系统用户数据传输对象。
     * @return 系统用户的响应对象。
     */
    SysUserResponse dtoToResponse(final SysUserDto sysUserDto);

}
