package cn.org.niubility.shutter.module.system.auth.mapper;

import cn.org.niubility.shutter.module.system.auth.dto.SysLoginDto;
import cn.org.niubility.shutter.module.system.auth.vo.SysLoginRequestVo;
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
     * Request转换成Dto。
     *
     * @param sysLoginRequestVo 系统登录的请求对象。
     * @return 系统登录数据传输对象。
     */
    @Mapping(target = "ip", ignore = true)
    SysLoginDto voToDto(final SysLoginRequestVo sysLoginRequestVo);

}
