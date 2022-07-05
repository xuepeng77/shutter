package cn.org.shutter.module.system.pos.service;

import cn.org.shutter.module.system.pos.dao.SysPosDao;
import cn.org.shutter.module.system.pos.dto.SysPosDto;
import cn.org.shutter.module.system.pos.entity.SysPos;
import cn.org.shutter.module.system.pos.enums.SysPosStatus;
import cn.org.shutter.module.system.pos.exception.SysPosNotFoundException;
import cn.org.shutter.module.system.pos.mapper.SysPosMapper;
import cn.org.shutter.sdk.mybatis.util.PageUtil;
import cn.org.shutter.sdk.mybatis.util.QueryWrapperUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统岗位的业务处理实现类。
 *
 * @author xuepeng
 */
@Service
@Slf4j
public class SysPosServiceImpl extends ServiceImpl<SysPosDao, SysPos> implements SysPosService {

    /**
     * 创建系统岗位。
     *
     * @param sysPosDto 系统岗位的的数据传输对象。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final SysPosDto sysPosDto) {
        final SysPos sysPos = sysPosMapper.dtoToEntity(sysPosDto);
        return super.save(sysPos);
    }

    /**
     * 修改系统岗位。
     *
     * @param sysPosDto 系统岗位的的数据传输对象。
     * @return 是否修改成功。
     */
    @Override
    public boolean update(final SysPosDto sysPosDto) {
        final SysPos sysPos = sysPosMapper.dtoToEntity(sysPosDto);
        return super.updateById(sysPos);
    }

    /**
     * 根据主键删除系统岗位。
     *
     * @param id 系统岗位的主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final long id) {
        // TODO 删除之前的校验
        return super.removeById(id);
    }

    /**
     * 根据主键停用系统岗位。
     *
     * @param id 系统岗位的主键。
     * @return 是否停用成功。
     */
    @Override
    public boolean disable(final long id) {
        final SysPos sysPos = new SysPos();
        sysPos.setId(id);
        sysPos.setStatus(SysPosStatus.DISABLE);
        return super.updateById(sysPos);
    }

    /**
     * 根据主键启用系统岗位。
     *
     * @param id 系统岗位的主键。
     * @return 是否启用成功。
     */
    @Override
    public boolean enable(final long id) {
        final SysPos sysPos = new SysPos();
        sysPos.setId(id);
        sysPos.setStatus(SysPosStatus.ENABLE);
        return super.updateById(sysPos);
    }

    /**
     * 根据主键查询系统岗位。
     * 当根据主键查询不到岗位时，抛出SysPosNotFoundException异常对象。
     *
     * @param id 系统岗位的主键。
     * @return 系统岗位的的数据传输对象。
     */
    @Override
    public SysPosDto findById(final long id) {
        final SysPos sysPos = super.getById(id);
        if (ObjectUtils.isEmpty(sysPos)) {
            throw new SysPosNotFoundException("根据主键[" + id + "]未能查询到系统岗位。");
        }
        return sysPosMapper.entityToDto(sysPos);
    }

    /**
     * 根据主键批量查询系统岗位。
     *
     * @param ids 系统岗位的主键集合。
     * @return 系统岗位的的数据传输对象集合。
     */
    @Override
    public List<SysPosDto> findByIds(final List<Long> ids) {
        final List<SysPos> sysPoss = super.listByIds(ids);
        return sysPosMapper.entityListToDtoList(sysPoss);
    }

    /**
     * 根据条件分页查询系统岗位。
     *
     * @param sysPosDto 系统岗位的数据传输对象。
     * @return 系统岗位的分页对象。
     */
    @Override
    public Page<SysPosDto> pageByCondition(final SysPosDto sysPosDto) {
        final QueryWrapper<SysPos> wrapper = createQueryWrapper(sysPosDto);
        final Page<SysPos> page = PageUtil.createPage(sysPosDto);
        final Page<SysPos> positions = super.page(page, wrapper);
        return sysPosMapper.entityPageToDtoPage(positions);
    }

    /**
     * @return 获取系统岗位对象转换接口。
     */
    @Override
    public SysPosMapper getSysPosMapper() {
        return this.sysPosMapper;
    }

    /**
     * 创建带条件的QueryWrapper。
     *
     * @param sysPosDto 系统岗位数据传输对象。
     * @return 带条件的QueryWrapper。
     */
    private QueryWrapper<SysPos> createQueryWrapper(final SysPosDto sysPosDto) {
        final SysPos sysPos = sysPosMapper.dtoToEntity(sysPosDto);
        final QueryWrapper<SysPos> wrapper = QueryWrapperUtil.createQueryWrapper(sysPosDto);
        final LambdaQueryWrapper<SysPos> lambda = wrapper.lambda();
        lambda.like(StringUtils.isNotBlank(sysPos.getName()), SysPos::getName, sysPos.getName());
        lambda.like(StringUtils.isNotBlank(sysPos.getCode()), SysPos::getCode, sysPos.getCode());
        lambda.eq(ObjectUtils.isNotEmpty(sysPos.getStatus()), SysPos::getStatus, sysPos.getStatus());
        return wrapper;
    }

    /**
     * 自动装配系统岗位对象转换接口。
     *
     * @param sysPosMapper 系统岗位对象转换接口。
     */
    @Autowired
    public void setSysPosMapper(SysPosMapper sysPosMapper) {
        this.sysPosMapper = sysPosMapper;
    }

    /**
     * 系统岗位对象转换接口。
     */
    private SysPosMapper sysPosMapper;

}
