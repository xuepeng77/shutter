package cn.org.niubility.shutter.module.system.log.service;

import cn.org.niubility.shutter.core.web.log.ApiLogInfo;
import cn.org.niubility.shutter.core.web.log.ApiLogPersistent;
import cn.org.niubility.shutter.module.system.log.dao.SysLogDao;
import cn.org.niubility.shutter.module.system.log.entity.SysLog;
import cn.org.niubility.shutter.module.system.log.mapper.SysLogMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLog> implements SysLogService, ApiLogPersistent {

    @Override
    public void saveAccessLog(final ApiLogInfo apiLogEntity) {
        final SysLog accessLog = sysLogMapper.apiLogInfoToEntity(apiLogEntity);
        save(accessLog);
    }

    @Override
    public void saveErrorLog(final ApiLogInfo apiLogEntity) {
        final SysLog errorLog = sysLogMapper.apiLogInfoToEntity(apiLogEntity);
        save(errorLog);
    }

    @Autowired
    public void setSysLogMapper(SysLogMapper sysLogMapper) {
        this.sysLogMapper = sysLogMapper;
    }

    private SysLogMapper sysLogMapper;

}
