package cn.org.niubility.shutter.module.system.user.service;

import cn.org.niubility.shutter.module.system.property.SystemProperty;
import cn.org.niubility.shutter.module.system.user.dao.SysUserDao;
import cn.org.niubility.shutter.module.system.user.dto.SysUserDto;
import cn.org.niubility.shutter.module.system.user.entity.SysUser;
import cn.org.niubility.shutter.module.system.user.exception.SysUserNotFoundException;
import cn.org.niubility.shutter.module.system.user.mapper.SysUserMapper;
import cn.org.niubility.shutter.module.system.user.service.password.PasswordStrategyFactory;
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
     * 创建系统用户。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return 是否创建成功。
     */
    public boolean create(final SysUserDto sysUserDto) {
        final SysUser sysUser = sysUserMapper.dtoToEntity(sysUserDto);
        // 创建默认密码
        final String password = passwordStrategyFactory
                .getInstance(systemConfig.getSysUserProperty().getPasswordStrategyType())
                .generate();
        sysUser.setPassword(password);
        return super.save(sysUser);
    }

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
     * 自动装配系统用户登录密码策略的工厂类。
     *
     * @param passwordStrategyFactory 系统用户登录密码策略的工厂类。
     */
    @Autowired
    public void setPasswordStrategyFactory(PasswordStrategyFactory passwordStrategyFactory) {
        this.passwordStrategyFactory = passwordStrategyFactory;
    }

    /**
     * 自动装配系统管理的自定义配置类。
     *
     * @param systemConfig 系统管理的自定义配置类。
     */
    @Autowired
    public void setSystemConfig(SystemProperty systemConfig) {
        this.systemConfig = systemConfig;
    }


    /**
     * 系统用户对象转换接口。
     */
    private SysUserMapper sysUserMapper;

    /**
     * 系统用户登录密码策略的工厂类。
     */
    private PasswordStrategyFactory passwordStrategyFactory;

    /**
     * 系统管理的自定义配置类。
     */
    private SystemProperty systemConfig;

}
