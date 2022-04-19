package cn.org.shutter.module.system.role.service;

import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.module.system.role.dao.SysRoleDao;
import cn.org.shutter.module.system.role.dto.SysRoleDto;
import cn.org.shutter.module.system.role.entity.SysRole;
import cn.org.shutter.module.system.role.enums.SysRoleStatus;
import cn.org.shutter.module.system.role.exception.SysRoleNotFoundException;
import cn.org.shutter.module.system.role.mapper.SysRoleMapper;
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
 * 系统角色的业务处理实现类。
 *
 * @author xuepeng
 */
@Service
@Slf4j
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

    /**
     * 创建系统角色。
     *
     * @param sysRoleDto 系统角色的数据传输对象。
     * @return 是否创建成功。
     */
    @Override
    public boolean create(final SysRoleDto sysRoleDto) {
        final SysRole sysRole = sysRoleMapper.dtoToEntity(sysRoleDto);
        return super.save(sysRole);
    }

    /**
     * 修改系统角色。
     *
     * @param sysRoleDto 系统角色的数据传输对象。
     * @return 是否修改成功。
     */
    @Override
    public boolean update(final SysRoleDto sysRoleDto) {
        final SysRole sysRole = sysRoleMapper.dtoToEntity(sysRoleDto);
        return super.updateById(sysRole);
    }

    /**
     * 根据主键删除系统角色。
     *
     * @param id 系统角色主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final long id) {
        return super.removeById(id);
    }

    /**
     * 根据主键批量删除系统角色。
     *
     * @param ids 系统角色主键集合。
     * @return 是否删除成功。
     */
    @Override
    public boolean deleteBatch(final List<Long> ids) {
        return super.removeByIds(ids);
    }

    /**
     * 根据主键停用系统角色。
     *
     * @param id 系统角色主键。
     * @return 是否停用成功。
     */
    @Override
    public boolean disable(final long id) {
        final SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setStatus(SysRoleStatus.DISABLE);
        return super.updateById(sysRole);
    }

    /**
     * 根据主键启用系统角色。
     *
     * @param id 系统角色主键。
     * @return 是否启用成功。
     */
    @Override
    public boolean enable(final long id) {
        final SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setStatus(SysRoleStatus.ENABLE);
        return super.updateById(sysRole);
    }

    /**
     * 根据主键查询系统角色。
     * 当根据主键查询不到角色时，抛出SysRoleNotFoundException异常对象。
     *
     * @param id 系统角色主键。
     * @return 系统角色的的数据传输对象。
     */
    @Override
    public SysRoleDto findById(final long id) {
        final SysRole sysRole = super.getById(id);
        // 当根据主键查询不到角色时，抛出SysRoleNotFoundException异常对象。
        if (ObjectUtils.isEmpty(sysRole)) {
            throw new SysRoleNotFoundException("根据主键[" + id + "]未能查询到系统角色。");
        }
        return sysRoleMapper.entityToDto(sysRole);
    }

    /**
     * 根据条件分页查询系统角色。
     *
     * @param sysRoleDto 系统角色的数据传输对象。
     * @return 系统角色的分页对象。
     */
    @Override
    public PageVo<SysRoleDto> pageByCondition(final SysRoleDto sysRoleDto) {
        final QueryWrapper<SysRole> wrapper = createQueryWrapper(sysRoleDto);
        final Page<SysRole> page = PageUtil.createPage(sysRoleDto);
        final Page<SysRole> roles = super.page(page, wrapper);
        return sysRoleMapper.entityPageToDtoPage(roles);
    }

    /**
     * 给一个系统角色授权多个系统用户。
     *
     * @param id      系统角色主键。
     * @param userIds 系统用户主键集合。
     */
    @Override
    public void saveUsers(final long id, final List<Long> userIds) {
        sysRoleUserService.saveUsersToRole(id, userIds);
    }

    /**
     * 查询系统角色下已授权的系统用户。
     *
     * @param id 系统角色主键。
     * @return 系统用户主键集合。
     */
    @Override
    public List<Long> findUsers(final long id) {
        return sysRoleUserService.findUsersByRoleId(id);
    }

    /**
     * 创建带条件的QueryWrapper。
     *
     * @param sysRoleDto 系统角色数据传输对象。
     * @return 带条件的QueryWrapper。
     */
    private QueryWrapper<SysRole> createQueryWrapper(final SysRoleDto sysRoleDto) {
        final SysRole sysRole = sysRoleMapper.dtoToEntity(sysRoleDto);
        final QueryWrapper<SysRole> wrapper = QueryWrapperUtil.createQueryWrapper(sysRoleDto);
        final LambdaQueryWrapper<SysRole> lambda = wrapper.lambda();
        if (StringUtils.isNotBlank(sysRole.getCode())) {
            lambda.like(SysRole::getCode, sysRole.getCode());
        }
        if (StringUtils.isNotBlank(sysRole.getName())) {
            lambda.like(SysRole::getName, sysRole.getName());
        }
        if (ObjectUtils.isNotEmpty(sysRole.getStatus())) {
            lambda.eq(SysRole::getStatus, sysRole.getStatus());
        }
        return wrapper;
    }

    /**
     * @return 获取系统角色对象转换接口。
     */
    @Override
    public SysRoleMapper getSysRoleMapper() {
        return this.sysRoleMapper;
    }

    /**
     * 自动装配系统角色对象转换接口。
     *
     * @param sysRoleMapper 系统角色对象转换接口。
     */
    @Autowired
    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    /**
     * 自动装配系统角色与系统用户关系的业务处理接口。
     *
     * @param sysRoleUserService 系统角色与系统用户关系的业务处理接口。
     */
    @Autowired
    public void setSysRoleUserService(SysRoleUserService sysRoleUserService) {
        this.sysRoleUserService = sysRoleUserService;
    }

    /**
     * 系统角色对象转换接口。
     */
    private SysRoleMapper sysRoleMapper;

    /**
     * 系统角色与系统用户关系的业务处理接口。
     */
    private SysRoleUserService sysRoleUserService;

}
