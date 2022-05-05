package cn.org.shutter.module.system.role.service;

import java.util.List;

/**
 * 系统角色与系统功能关系的业务处理接口。
 *
 * @author xuepeng
 */
public interface SysRoleFuncService {

    /**
     * 给一个系统角色授权多个系统功能。
     *
     * @param roleId  系统角色的主键。
     * @param funcIds 系统功能的主键集合。
     */
    void saveFuncsToRole(final long roleId, final List<Long> funcIds);

    /**
     * 给一个系统功能授权多个系统角色。
     *
     * @param funcId  系统功能的主键。
     * @param roleIds 系统角色的主键集合。
     */
    void saveRolesToFunc(final long funcId, final List<Long> roleIds);

    /**
     * 查询系统角色下已授权的系统功能。
     *
     * @param roleId 系统角色的主键。
     * @return 系统功能的主键集合。
     */
    List<Long> findFuncsByRoleId(final long roleId);

    /**
     * 查询系统角色下已授权的系统功能。
     *
     * @param roleIds 系统角色的主键集合。
     * @return 系统功能的主键集合。
     */
    List<Long> findFuncsByRoleId(final List<Long> roleIds);

}
