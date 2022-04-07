package cn.org.shutter.module.system.log.service;

import cn.org.shutter.core.web.log.ApiLogInfo;
import cn.org.shutter.core.web.log.ApiLogPersistent;
import cn.org.shutter.module.system.log.dao.SysLogDao;
import cn.org.shutter.module.system.log.entity.SysLog;
import cn.org.shutter.module.system.log.enums.SysLogType;
import cn.org.shutter.module.system.log.mapper.SysLogMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统日志的业务处理实现类。
 * 实现了ApiLogPersistent接口，为ApiLog注解提供持久化实现。
 *
 * @author xuepeng
 */
@Service
@Slf4j
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLog> implements SysLogService, ApiLogPersistent {

    /**
     * 保存访问日志。
     *
     * @param apiLogEntity API日志对象。
     */
    @Override
    public void saveAccessLog(final ApiLogInfo apiLogEntity) {
        final SysLog accessLog = sysLogMapper.apiLogInfoToEntity(apiLogEntity);
        accessLog.setType(SysLogType.ACCESS);
        super.save(accessLog);
    }

    /**
     * 保存错误日志。
     *
     * @param apiLogEntity API日志对象。
     */
    @Override
    public void saveErrorLog(final ApiLogInfo apiLogEntity) {
        final SysLog errorLog = sysLogMapper.apiLogInfoToEntity(apiLogEntity);
        errorLog.setType(SysLogType.ERROR);
        super.save(errorLog);
    }

    /**
     * 自动装配系统日志对象转换接口。
     *
     * @param sysLogMapper 系统日志对象转换接口。
     */
    @Autowired
    public void setSysLogMapper(SysLogMapper sysLogMapper) {
        this.sysLogMapper = sysLogMapper;
    }

    /**
     * 系统日志对象转换接口。
     */
    private SysLogMapper sysLogMapper;

}
