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
     * 根据主键查询系统用户。
     * 当根据主键查询不到用户时，抛出SysUserNotFoundException异常对象。
     *
     * @param id 系统用户主键。
     * @return 系统用户的的数据传输对象。
     */
    SysUserDto findById(final long id);

}
