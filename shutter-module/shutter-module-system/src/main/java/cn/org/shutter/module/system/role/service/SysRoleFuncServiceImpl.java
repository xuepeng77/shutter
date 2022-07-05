package cn.org.shutter.module.system.role.service;

import cn.org.shutter.module.system.role.dao.SysRoleFuncDao;
import cn.org.shutter.module.system.role.entity.SysRoleFunc;
import cn.org.shutter.sdk.mybatis.util.QueryWrapperUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统角色与系统功能关系的业务处理实现类。
 *
 * @author xuepeng
 */
@Service
@Slf4j
public class SysRoleFuncServiceImpl extends ServiceImpl<SysRoleFuncDao, SysRoleFunc> implements SysRoleFuncService {

    /**
     * 给一个系统角色授权多个系统功能。
     *
     * @param roleId  系统角色的主键。
     * @param funcIds 系统功能的主键集合。
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveFuncsToRole(final long roleId, final List<Long> funcIds) {
        // 删除关系
        super.remove(
                createQueryWrapper().lambda().eq(SysRoleFunc::getRoleId, roleId)
        );
        // 创建关系
        if (CollectionUtils.isNotEmpty(funcIds)) {
            final List<SysRoleFunc> sysRoleFuncs = new ArrayList<>(funcIds.size());
            funcIds.forEach(funcId -> {
                final SysRoleFunc sysRoleFunc = new SysRoleFunc();
                sysRoleFunc.setRoleId(roleId);
                sysRoleFunc.setFuncId(funcId);
                sysRoleFuncs.add(sysRoleFunc);
            });
            super.saveBatch(sysRoleFuncs);
        }
    }

    /**
     * 给一个系统功能授权多个系统角色。
     *
     * @param funcId  系统功能的主键。
     * @param roleIds 系统角色的主键集合。
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRolesToFunc(final long funcId, final List<Long> roleIds) {
        // 删除关系
        super.remove(
                createQueryWrapper().lambda().eq(SysRoleFunc::getFuncId, funcId)
        );
        // 创建关系
        if (CollectionUtils.isNotEmpty(roleIds)) {
            final List<SysRoleFunc> sysRoleFuncs = new ArrayList<>(roleIds.size());
            roleIds.forEach(roleId -> {
                final SysRoleFunc sysRoleFunc = new SysRoleFunc();
                sysRoleFunc.setFuncId(funcId);
                sysRoleFunc.setRoleId(roleId);
                sysRoleFuncs.add(sysRoleFunc);
            });
            super.saveBatch(sysRoleFuncs);
        }
    }

    /**
     * 查询系统角色下已授权的系统功能。
     *
     * @param roleId 系统角色的主键。
     * @return 系统功能的主键集合。
     */
    @Override
    public List<Long> findFuncsByRoleId(final long roleId) {
        final List<SysRoleFunc> sysRoleFuncs = super.list(
                createQueryWrapper().lambda().eq(SysRoleFunc::getRoleId, roleId)
        );
        return sysRoleFuncs.stream()
                .map(SysRoleFunc::getFuncId)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * 查询系统角色下已授权的系统功能。
     *
     * @param roleIds 系统角色的主键集合。
     * @return 系统功能的主键集合。
     */
    @Override
    public List<Long> findFuncsByRoleId(final List<Long> roleIds) {
        final List<SysRoleFunc> sysRoleFuncs = super.list(
                createQueryWrapper().lambda().in(SysRoleFunc::getRoleId, roleIds)
        );
        return sysRoleFuncs.stream()
                .map(SysRoleFunc::getFuncId)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * 查询系统角色下是否有已授权的系统功能。
     *
     * @param roleId 系统角色的主键。
     * @return 是否有已授权的系统功能。
     */
    @Override
    public boolean hasFuncsByRoleId(final long roleId) {
        return super.count(
                createQueryWrapper().lambda().eq(SysRoleFunc::getRoleId, roleId)
        ) > 0;
    }

    /**
     * @return 创建QueryWrapper查询对象。
     */
    private QueryWrapper<SysRoleFunc> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

}
