package cn.org.shutter.module.system.role.service;

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
     * @param id 系统角色的主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final long id) {
        // TODO 删除之前的校验
        return super.removeById(id);
    }

    /**
     * 根据主键停用系统角色。
     *
     * @param id 系统角色的主键。
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
     * @param id 系统角色的主键。
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
     * @param id 系统角色的主键。
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
     * 根据主键查询系统角色。
     *
     * @param ids 系统角色的主键集合。
     * @return 系统角色的的数据传输对象集合。
     */
    @Override
    public List<SysRoleDto> findByIds(final List<Long> ids) {
        final List<SysRole> sysRoles = super.listByIds(ids);
        return sysRoleMapper.entityListToDtoList(sysRoles);
    }

    /**
     * 根据条件分页查询系统角色。
     *
     * @param sysRoleDto 系统角色的数据传输对象。
     * @return 系统角色的分页对象。
     */
    @Override
    public Page<SysRoleDto> pageByCondition(final SysRoleDto sysRoleDto) {
        final QueryWrapper<SysRole> wrapper = createQueryWrapper(sysRoleDto);
        wrapper.lambda().orderByAsc(SysRole::getOrderId);
        final Page<SysRole> page = PageUtil.createPage(sysRoleDto);
        final Page<SysRole> roles = super.page(page, wrapper);
        return sysRoleMapper.entityPageToDtoPage(roles);
    }

    /**
     * 给一个系统角色授权多个系统用户。
     *
     * @param id      系统角色的主键。
     * @param userIds 系统用户的主键集合。
     */
    @Override
    public void saveUsers(final long id, final List<Long> userIds) {
        sysRoleUserService.saveUsersToRole(id, userIds);
    }

    /**
     * 查询系统角色下已授权的系统用户。
     *
     * @param id 系统角色的主键。
     * @return 系统用户的主键集合。
     */
    @Override
    public List<Long> findUsers(final long id) {
        return sysRoleUserService.findUsersByRoleId(id);
    }

    /**
     * 给一个系统角色授权多个系统功能。
     *
     * @param id      系统角色的主键。
     * @param funcIds 系统功能的主键集合。
     */
    @Override
    public void saveFuncs(final long id, final List<Long> funcIds) {
        sysRoleFuncService.saveFuncsToRole(id, funcIds);
    }

    /**
     * 查询系统角色下已授权的系统功能。
     *
     * @param id 系统角色的主键。
     * @return 系统功能的主键集合。
     */
    @Override
    public List<Long> findFuncs(final long id) {
        return sysRoleFuncService.findFuncsByRoleId(id);
    }

    /**
     * 查询系统角色下已授权的系统功能。
     *
     * @param ids 系统角色的主键集合。
     * @return 系统功能的主键集合。
     */
    @Override
    public List<Long> findFuncs(final List<Long> ids) {
        return sysRoleFuncService.findFuncsByRoleId(ids);
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
        lambda.like(StringUtils.isNotBlank(sysRole.getCode()), SysRole::getCode, sysRole.getCode());
        lambda.like(StringUtils.isNotBlank(sysRole.getName()), SysRole::getName, sysRole.getName());
        lambda.eq(ObjectUtils.isNotEmpty(sysRole.getStatus()), SysRole::getStatus, sysRole.getStatus());
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
     * 自动装配系统角色与系统功能关系的业务处理接口。
     *
     * @param sysRoleFuncService 系统角色与系统功能关系的业务处理接口。
     */
    @Autowired
    public void setSysRoleFuncService(SysRoleFuncService sysRoleFuncService) {
        this.sysRoleFuncService = sysRoleFuncService;
    }

    /**
     * 系统角色对象转换接口。
     */
    private SysRoleMapper sysRoleMapper;

    /**
     * 系统角色与系统用户关系的业务处理接口。
     */
    private SysRoleUserService sysRoleUserService;

    /**
     * 系统角色与系统功能关系的业务处理接口。
     */
    private SysRoleFuncService sysRoleFuncService;

}
