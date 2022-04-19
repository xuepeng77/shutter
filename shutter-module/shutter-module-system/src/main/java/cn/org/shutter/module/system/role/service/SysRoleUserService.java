package cn.org.shutter.module.system.role.service;

import java.util.List;

/**
 * 系统角色与系统用户关系的业务处理接口。
 *
 * @author xuepeng
 */
public interface SysRoleUserService {

    /**
     * 给一个系统角色授权多个系统用户。
     *
     * @param roleId  系统角色主键。
     * @param userIds 系统用户主键集合。
     */
    void saveUsersToRole(final long roleId, final List<Long> userIds);

    /**
     * 给一个系统用户授权多个系统角色。
     *
     * @param userId  系统用户主键。
     * @param roleIds 系统角色主键集合。
     */
    void saveRolesToUser(final long userId, final List<Long> roleIds);

    /**
     * 查询系统角色下已授权的系统用户。
     *
     * @param roleId 系统角色主键。
     * @return 系统用户主键集合。
     */
    List<Long> findUsersByRoleId(final long roleId);

    /**
     * 查询系统用户下已授权的系统角色。
     *
     * @param userId 系统用户主键。
     * @return 系统角色主键集合。
     */
    List<Long> findRolesByUserId(final long userId);

}
