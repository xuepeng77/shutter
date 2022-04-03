package cn.org.niubility.shutter.module.system.user.service;

import cn.org.niubility.shutter.module.system.user.dto.SysUserDto;
import cn.org.niubility.shutter.module.system.user.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 更新系统用户。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return 是否更新成功。
     */
    boolean update(final SysUserDto sysUserDto);

    /**
     * 根据主键删除系统用户。
     *
     * @param id 系统用户主键。
     * @return 是否删除成功。
     */
    boolean deleteById(final long id);

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
