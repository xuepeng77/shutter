package cn.org.shutter.module.system.user.service;

import cn.org.shutter.module.system.user.dto.SysUserDto;
import cn.org.shutter.module.system.user.entity.SysUser;
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
     * @param id 系统用户主键。
     * @return 是否删除成功。
     */
    boolean delete(final long id);

    /**
     * 根据主键批量删除系统用户。
     *
     * @param ids 系统用户主键集合。
     * @return 是否删除成功。
     */
    boolean deleteBatch(final List<Long> ids);

    /**
     * 根据主键查询系统用户。
     * 当根据主键查询不到用户时，抛出SysUserNotFoundException异常对象。
     *
     * @param id 系统用户主键。
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

}