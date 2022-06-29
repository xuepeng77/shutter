package cn.org.shutter.module.system.dept.service;

import cn.org.shutter.core.common.util.TreeUtil;
import cn.org.shutter.module.system.dept.dao.SysDeptDao;
import cn.org.shutter.module.system.dept.dto.SysDeptDto;
import cn.org.shutter.module.system.dept.entity.SysDept;
import cn.org.shutter.module.system.dept.enums.SysDeptStatus;
import cn.org.shutter.module.system.dept.exception.SysDeptNotFoundException;
import cn.org.shutter.module.system.dept.mapper.SysDeptMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统组织机构的业务处理实现类。
 *
 * @author xuepeng
 */
@Service
@Slf4j
public class SysDeptServiceImpl extends ServiceImpl<SysDeptDao, SysDept> implements SysDeptService {

    /**
     * 创建系统组织机构。
     *
     * @param sysDeptDto 系统组织机构的的数据传输对象。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final SysDeptDto sysDeptDto) {
        final SysDept sysDept = sysDeptMapper.dtoToEntity(sysDeptDto);
        return super.save(sysDept);
    }

    /**
     * 修改系统组织机构。
     *
     * @param sysDeptDto 系统组织机构的的数据传输对象。
     * @return 是否修改成功。
     */
    @Override
    public boolean update(final SysDeptDto sysDeptDto) {
        final SysDept sysDept = sysDeptMapper.dtoToEntity(sysDeptDto);
        return super.updateById(sysDept);
    }

    /**
     * 根据主键删除系统组织机构。
     *
     * @param id 系统组织机构的主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final long id) {
        // TODO 删除之前的校验
        return super.removeById(id);
    }

    /**
     * 根据主键停用系统组织机构。
     *
     * @param id 系统组织机构的主键。
     * @return 是否停用成功。
     */
    @Override
    public boolean disable(final long id) {
        final SysDept sysDept = new SysDept();
        sysDept.setId(id);
        sysDept.setStatus(SysDeptStatus.DISABLE);
        return super.updateById(sysDept);
    }

    /**
     * 根据主键启用系统组织机构。
     *
     * @param id 系统组织机构的主键。
     * @return 是否启用成功。
     */
    @Override
    public boolean enable(final long id) {
        final SysDept sysDept = new SysDept();
        sysDept.setId(id);
        sysDept.setStatus(SysDeptStatus.ENABLE);
        return super.updateById(sysDept);
    }

    /**
     * 根据主键查询系统组织机构。
     * 当根据主键查询不到组织机构时，抛出SysDeptNotFoundException异常对象。
     *
     * @param id 系统组织机构的主键。
     * @return 系统组织机构的的数据传输对象。
     */
    @Override
    public SysDeptDto findById(final long id) {
        final SysDept sysDept = super.getById(id);
        if (ObjectUtils.isEmpty(sysDept)) {
            throw new SysDeptNotFoundException("根据主键[" + id + "]未能查询到系统组织机构。");
        }
        return sysDeptMapper.entityToDto(sysDept);
    }

    /**
     * 根据主键批量查询系统组织机构。
     *
     * @param ids 系统组织机构的主键集合。
     * @return 系统组织机构的的数据传输对象集合。
     */
    @Override
    public List<SysDeptDto> findByIds(final List<Long> ids) {
        final List<SysDept> sysDepts = super.listByIds(ids);
        return sysDeptMapper.entityListToDtoList(sysDepts);
    }

    /**
     * 查询全部系统组织机构并转换成树。
     *
     * @return 系统组织机构的数据传输对象树。
     */
    @Override
    public List<SysDeptDto> findAllToTree() {
        final List<SysDept> sysDepts = super.list();
        final List<SysDeptDto> sysDeptDtos = getSysDeptMapper().entityListToDtoList(sysDepts);
        return TreeUtil.format(sysDeptDtos);
    }

    /**
     * @return 获取系统组织机构对象转换接口。
     */
    @Override
    public SysDeptMapper getSysDeptMapper() {
        return this.sysDeptMapper;
    }

    /**
     * 自动装配系统组织机构对象转换接口。
     *
     * @param sysDeptMapper 系统组织机构对象转换接口。
     */
    @Autowired
    public void setSysDeptMapper(SysDeptMapper sysDeptMapper) {
        this.sysDeptMapper = sysDeptMapper;
    }

    /**
     * 系统组织机构对象转换接口。
     */
    private SysDeptMapper sysDeptMapper;

}
