package cn.org.shutter.module.system.role.service;

import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.module.system.role.dto.SysRoleDto;
import cn.org.shutter.module.system.role.mapper.SysRoleMapper;

import java.util.List;

/**
 * 系统角色的业务处理接口。
 *
 * @author xuepeng
 */
public interface SysRoleService {

    /**
     * 创建系统角色。
     *
     * @param sysRoleDto 系统角色的数据传输对象。
     * @return 是否创建成功。
     */
    boolean create(final SysRoleDto sysRoleDto);

    /**
     * 修改系统角色。
     *
     * @param sysRoleDto 系统角色的数据传输对象。
     * @return 是否修改成功。
     */
    boolean update(final SysRoleDto sysRoleDto);

    /**
     * 根据主键删除系统角色。
     *
     * @param id 系统角色主键。
     * @return 是否删除成功。
     */
    boolean delete(final long id);

    /**
     * 根据主键批量删除系统角色。
     *
     * @param ids 系统角色主键集合。
     * @return 是否删除成功。
     */
    boolean deleteBatch(final List<Long> ids);

    /**
     * 根据主键停用系统角色。
     *
     * @param id 系统角色主键。
     * @return 是否停用成功。
     */
    boolean disable(final long id);

    /**
     * 根据主键启用系统角色。
     *
     * @param id 系统角色主键。
     * @return 是否启用成功。
     */
    boolean enable(final long id);

    /**
     * 根据主键查询系统角色。
     * 当根据主键查询不到角色时，抛出SysRoleNotFoundException异常对象。
     *
     * @param id 系统角色主键。
     * @return 系统角色的的数据传输对象。
     */
    SysRoleDto findById(final long id);

    /**
     * 根据主键查询系统角色。
     *
     * @param ids 系统角色主键集合。
     * @return 系统角色的的数据传输对象集合。
     */
    List<SysRoleDto> findByIds(final List<Long> ids);

    /**
     * 根据条件分页查询系统角色。
     *
     * @param sysRoleDto 系统角色的数据传输对象。
     * @return 系统角色的分页对象。
     */
    PageVo<SysRoleDto> pageByCondition(final SysRoleDto sysRoleDto);

    /**
     * 给一个系统角色授权多个系统用户。
     *
     * @param id      系统角色主键。
     * @param userIds 系统用户主键集合。
     */
    void saveUsers(final long id, final List<Long> userIds);

    /**
     * 查询系统角色下已授权的系统用户。
     *
     * @param id 系统角色主键。
     * @return 系统用户主键集合。
     */
    List<Long> findUsers(final long id);

    /**
     * @return 获取系统角色对象转换接口。
     */
    SysRoleMapper getSysRoleMapper();

}
