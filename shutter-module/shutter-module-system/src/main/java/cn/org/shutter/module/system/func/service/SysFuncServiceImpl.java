package cn.org.shutter.module.system.func.service;

import cn.org.shutter.core.common.util.TreeUtil;
import cn.org.shutter.module.system.func.dao.SysFuncDao;
import cn.org.shutter.module.system.func.dto.SysFuncDto;
import cn.org.shutter.module.system.func.entity.SysFunc;
import cn.org.shutter.module.system.func.enums.SysFuncStatus;
import cn.org.shutter.module.system.func.exception.SysFuncNotFoundException;
import cn.org.shutter.module.system.func.mapper.SysFuncMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
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
     * 创建系统功能。
     *
     * @param sysFuncDto 系统功能的的数据传输对象。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final SysFuncDto sysFuncDto) {
        final SysFunc sysFunc = sysFuncMapper.dtoToEntity(sysFuncDto);
        return super.save(sysFunc);
    }

    /**
     * 修改系统功能。
     *
     * @param sysFuncDto 系统功能的的数据传输对象。
     * @return 是否修改成功。
     */
    @Override
    public boolean update(final SysFuncDto sysFuncDto) {
        final SysFunc sysFunc = sysFuncMapper.dtoToEntity(sysFuncDto);
        return super.updateById(sysFunc);
    }

    /**
     * 根据主键删除系统功能。
     *
     * @param id 系统功能的主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final long id) {
        // TODO 删除之前的校验
        return super.removeById(id);
    }

    /**
     * 根据主键停用系统功能。
     *
     * @param id 系统功能的主键。
     * @return 是否停用成功。
     */
    @Override
    public boolean disable(final long id) {
        final SysFunc sysFunc = new SysFunc();
        sysFunc.setId(id);
        sysFunc.setStatus(SysFuncStatus.DISABLE);
        return super.updateById(sysFunc);
    }

    /**
     * 根据主键启用系统功能。
     *
     * @param id 系统功能的主键。
     * @return 是否启用成功。
     */
    @Override
    public boolean enable(final long id) {
        final SysFunc sysFunc = new SysFunc();
        sysFunc.setId(id);
        sysFunc.setStatus(SysFuncStatus.ENABLE);
        return super.updateById(sysFunc);
    }

    /**
     * 根据主键查询系统功能。
     * 当根据主键查询不到功能时，抛出SysFuncNotFoundException异常对象。
     *
     * @param id 系统功能的主键。
     * @return 系统功能的的数据传输对象。
     */
    @Override
    public SysFuncDto findById(final long id) {
        final SysFunc sysFunc = super.getById(id);
        if (ObjectUtils.isEmpty(sysFunc)) {
            throw new SysFuncNotFoundException("根据主键[" + id + "]未能查询到系统功能。");
        }
        return sysFuncMapper.entityToDto(sysFunc);
    }

    /**
     * 根据主键批量查询系统功能。
     *
     * @param ids 系统功能的主键集合。
     * @return 系统功能的的数据传输对象集合。
     */
    @Override
    public List<SysFuncDto> findByIds(final List<Long> ids) {
        final List<SysFunc> sysFuncs = super.listByIds(ids);
        return sysFuncMapper.entityListToDtoList(sysFuncs);
    }

    /**
     * 查询全部系统功能并转换成树。
     *
     * @return 系统功能的数据传输对象树。
     */
    @Override
    public List<SysFuncDto> findAllToTree() {
        final List<SysFunc> sysFuncs = super.list();
        final List<SysFuncDto> sysFuncDtos = getSysFuncMapper().entityListToDtoList(sysFuncs);
        return TreeUtil.format(sysFuncDtos);
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
