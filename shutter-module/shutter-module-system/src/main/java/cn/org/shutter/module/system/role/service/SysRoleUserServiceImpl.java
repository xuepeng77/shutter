package cn.org.shutter.module.system.role.service;

import cn.org.shutter.module.system.role.dao.SysRoleUserDao;
import cn.org.shutter.module.system.role.entity.SysRoleUser;
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
 * 系统角色与系统用户关系的业务处理实现类。
 *
 * @author xuepeng
 */
@Service
@Slf4j
public class SysRoleUserServiceImpl extends ServiceImpl<SysRoleUserDao, SysRoleUser> implements SysRoleUserService {

    /**
     * 给一个系统角色授权多个系统用户。
     *
     * @param roleId  系统角色的主键。
     * @param userIds 系统用户的主键集合。
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUsersToRole(final long roleId, final List<Long> userIds) {
        // 删除关系
        super.remove(
                createQueryWrapper().lambda().eq(SysRoleUser::getRoleId, roleId)
        );
        // 创建关系
        if (CollectionUtils.isNotEmpty(userIds)) {
            final List<SysRoleUser> sysRoleUsers = new ArrayList<>(userIds.size());
            userIds.forEach(userId -> {
                final SysRoleUser sysRoleUser = new SysRoleUser();
                sysRoleUser.setRoleId(roleId);
                sysRoleUser.setUserId(userId);
                sysRoleUsers.add(sysRoleUser);
            });
            super.saveBatch(sysRoleUsers);
        }
    }

    /**
     * 给一个系统用户授权多个系统角色。
     *
     * @param userId  系统用户的主键。
     * @param roleIds 系统角色的主键集合。
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRolesToUser(final long userId, final List<Long> roleIds) {
        // 删除关系
        super.remove(
                createQueryWrapper().lambda().eq(SysRoleUser::getUserId, userId)
        );
        // 创建关系
        if (CollectionUtils.isNotEmpty(roleIds)) {
            final List<SysRoleUser> sysRoleUsers = new ArrayList<>(roleIds.size());
            roleIds.forEach(roleId -> {
                final SysRoleUser sysRoleUser = new SysRoleUser();
                sysRoleUser.setUserId(userId);
                sysRoleUser.setRoleId(roleId);
                sysRoleUsers.add(sysRoleUser);
            });
            super.saveBatch(sysRoleUsers);
        }
    }

    /**
     * 查询系统角色下已授权的系统用户。
     *
     * @param roleId 系统角色的主键。
     * @return 系统用户的主键集合。
     */
    @Override
    public List<Long> findUsersByRoleId(final long roleId) {
        final List<SysRoleUser> sysRoleUsers = super.list(
                createQueryWrapper().lambda().eq(SysRoleUser::getRoleId, roleId)
        );
        return sysRoleUsers.stream()
                .map(SysRoleUser::getUserId)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * 查询系统用户下已授权的系统角色。
     *
     * @param userId 系统用户的主键。
     * @return 系统角色的主键集合。
     */
    @Override
    public List<Long> findRolesByUserId(final long userId) {
        final List<SysRoleUser> sysRoleUsers = super.list(
                createQueryWrapper().lambda().eq(SysRoleUser::getUserId, userId)
        );
        return sysRoleUsers.stream()
                .map(SysRoleUser::getRoleId)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * @return 创建QueryWrapper查询对象。
     */
    private QueryWrapper<SysRoleUser> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

}
