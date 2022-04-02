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

    /**
     * ApiLogInfo转换成Entity。
     *
     * @param apiLogInfo API日志对象。
     * @return API日志实体对象。
     */
    SysLog apiLogInfoToEntity(final ApiLogInfo apiLogInfo);

}
