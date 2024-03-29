package cn.org.shutter.module.system.login.mapper;

import cn.org.shutter.module.system.login.dto.SysLoginDto;
import cn.org.shutter.module.system.login.param.SysLoginParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 系统登录对象转换接口。
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysLoginMapper {

    /**
     * Param转换成Dto。
     *
     * @param sysLoginParam 系统登录的请求对象。
     * @return 系统登录的数据传输对象。
     */
    @Mapping(target = "ip", ignore = true)
    SysLoginDto paramToDto(final SysLoginParam sysLoginParam);

}
