package cn.org.shutter.module.system.user.service;

import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.module.system.user.dto.SysUserDto;
import cn.org.shutter.module.system.user.entity.SysUser;
import cn.org.shutter.module.system.user.mapper.SysUserMapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 系统用户的业务处理接口。
 *
 * @author xuepeng
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 创建系统用户。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return 是否创建成功。
     */
    boolean create(final SysUserDto sysUserDto);

    /**
     * 修改系统用户。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return 是否修改成功。
     */
    boolean update(final SysUserDto sysUserDto);

    /**
     * 根据主键删除系统用户。
     *
     * @param id 系统用户的主键。
     * @return 是否删除成功。
     */
    boolean delete(final long id);

    /**
     * 根据主键批量删除系统用户。
     *
     * @param ids 系统用户的主键集合。
     * @return 是否删除成功。
     */
    boolean deleteBatch(final List<Long> ids);

    /**
     * 根据主键停用系统用户。
     *
     * @param id 系统用户的主键。
     * @return 是否停用成功。
     */
    boolean disable(final long id);

    /**
     * 根据主键启用系统用户。
     *
     * @param id 系统用户的主键。
     * @return 是否启用成功。
     */
    boolean enable(final long id);

    /**
     * 根据主键重置系统用户的登录密码。
     *
     * @param id 系统用户的主键。
     * @return 是否重置成功。
     */
    boolean resetPassword(final long id);

    /**
     * 验证密码是否正确。
     *
     * @param input    输入的密码。
     * @param password 数据库中的密码。
     * @return 密码是否正确。
     */
    boolean verifyPassword(final String input, final String password);

    /**
     * 根据主键查询系统用户。
     * 当根据主键查询不到用户时，抛出SysUserNotFoundException异常对象。
     *
     * @param id 系统用户的主键。
     * @return 系统用户的的数据传输对象。
     */
    SysUserDto findById(final long id);

    /**
     * 根据帐号查询系统用户。
     *
     * @param account 帐号。
     * @return 系统用户的数据传输对象。
     */
    SysUserDto findByAccount(final String account);

    /**
     * 根据条件分页查询系统用户。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return 系统用户的分页对象。
     */
    PageVo<SysUserDto> pageByCondition(final SysUserDto sysUserDto);

    /**
     * 给一个系统用户授权多个系统角色。
     *
     * @param id      系统用户的主键。
     * @param roleIds 系统角色主键集合。
     */
    void saveRoles(final long id, final List<Long> roleIds);

    /**
     * 查询系统用户下已授权的系统角色。
     *
     * @param id 系统用户的主键。
     * @return 系统角色主键集合。
     */
    List<Long> findRoles(final long id);

    /**
     * @return 获取系统用户对象转换接口。
     */
    SysUserMapper getSysUserMapper();

}
