package cn.org.niubility.shutter.module.system.user.service;

import cn.org.niubility.shutter.module.system.user.dao.SysUserDao;
import cn.org.niubility.shutter.module.system.user.dto.SysUserDto;
import cn.org.niubility.shutter.module.system.user.entity.SysUser;
import cn.org.niubility.shutter.module.system.user.exception.SysUserNotFoundException;
import cn.org.niubility.shutter.module.system.user.mapper.SysUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统用户的业务处理实现类。
 *
 * @author xuepeng
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    /**
     * 根据主键查询系统用户。
     * 当根据主键查询不到用户时，抛出SysUserNotFoundException异常对象。
     *
     * @param id 系统用户主键。
     * @return 系统用户的的数据传输对象。
     */
    @Override
    public SysUserDto findById(final long id) {
        final SysUser sysUser = super.getById(id);
        // 当根据主键查询不到用户时，抛出SysUserNotFoundException异常对象。
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new SysUserNotFoundException("根据主键[" + id + "]未能查询到系统用户。");
        }
        final SysUserDto result = sysUserMapper.entityToDto(sysUser);
        if (log.isDebugEnabled()) {
            log.debug("根据主键：{}，查询用户：{}", id, result.toString());
        }
        return result;
    }

    /**
     * 自动装配系统用户对象转换接口。
     *
     * @param sysUserMapper 系统用户对象转换接口。
     */
    @Autowired
    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 系统用户对象转换接口。
     */
    private SysUserMapper sysUserMapper;

}
