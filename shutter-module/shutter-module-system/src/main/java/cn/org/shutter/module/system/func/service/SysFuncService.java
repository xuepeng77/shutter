package cn.org.shutter.module.system.func.service;

import cn.org.shutter.module.system.func.dto.SysFuncDto;
import cn.org.shutter.module.system.func.mapper.SysFuncMapper;

import java.util.List;

/**
 * 系统功能的业务处理接口。
 *
 * @author xuepeng
 */
public interface SysFuncService {

    /**
     * @return 查询全部系统功能。
     */
    List<SysFuncDto> findAll();

    /**
     * @return 获取系统功能对象转换接口。
     */
    SysFuncMapper getSysFuncMapper();
    
}
