package cn.org.niubility.shutter.module.system.log.mapper;

import cn.org.niubility.shutter.core.web.log.ApiLogInfo;
import cn.org.niubility.shutter.module.system.log.entity.SysLog;
import org.mapstruct.Mapper;

/**
 * 系统日志对象转换接口。
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring")
public interface SysLogMapper {

    SysLog apiLogInfoToEntity(final ApiLogInfo apiLogInfo);

}
