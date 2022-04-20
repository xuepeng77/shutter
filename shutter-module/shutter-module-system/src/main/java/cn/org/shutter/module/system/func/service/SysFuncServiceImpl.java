package cn.org.shutter.module.system.func.service;

import cn.org.shutter.module.system.func.dao.SysFuncDao;
import cn.org.shutter.module.system.func.dto.SysFuncDto;
import cn.org.shutter.module.system.func.entity.SysFunc;
import cn.org.shutter.module.system.func.mapper.SysFuncMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统功能的业务处理实现类。
 *
 * @author xuepeng
 */
@Service
@Slf4j
public class SysFuncServiceImpl extends ServiceImpl<SysFuncDao, SysFunc> implements SysFuncService {

    /**
     * @return 查询全部系统功能。
     */
    @Override
    public List<SysFuncDto> findAll() {
        final List<SysFunc> sysFuncs = super.list();
        return getSysFuncMapper().entityListToDtoList(sysFuncs);
    }

    /**
     * @return 获取系统功能对象转换接口。
     */
    @Override
    public SysFuncMapper getSysFuncMapper() {
        return this.sysFuncMapper;
    }

    /**
     * 自动装配系统功能对象转换接口。
     *
     * @param sysFuncMapper 系统功能对象转换接口。
     */
    @Autowired
    public void setSysFuncMapper(SysFuncMapper sysFuncMapper) {
        this.sysFuncMapper = sysFuncMapper;
    }

    /**
     * 系统功能对象转换接口。
     */
    private SysFuncMapper sysFuncMapper;

}
