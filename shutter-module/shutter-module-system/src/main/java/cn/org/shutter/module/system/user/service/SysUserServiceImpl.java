package cn.org.shutter.module.system.user.service;

import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.module.property.SystemProperty;
import cn.org.shutter.module.system.user.dao.SysUserDao;
import cn.org.shutter.module.system.user.dto.SysUserDto;
import cn.org.shutter.module.system.user.entity.SysUser;
import cn.org.shutter.module.system.user.enums.SysUserStatus;
import cn.org.shutter.module.system.user.exception.SysUserNotFoundException;
import cn.org.shutter.module.system.user.mapper.SysUserMapper;
import cn.org.shutter.module.system.user.service.password.PasswordStrategy;
import cn.org.shutter.module.system.user.service.password.PasswordStrategyFactory;
import cn.org.shutter.sdk.mybatis.consts.QueryConst;
import cn.org.shutter.sdk.mybatis.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        // 生成默认的登录密码
        final String password = getPasswordStrategy().generate();
        sysUser.setPassword(password);
        return super.save(sysUser);
    }

    /**
     * 修改系统用户。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return 是否修改成功。
     */
    @Override
    public boolean update(final SysUserDto sysUserDto) {
        final SysUser sysUser = sysUserMapper.dtoToEntity(sysUserDto);
        return super.updateById(sysUser);
    }

    /**
     * 根据主键删除系统用户。
     *
     * @param id 系统用户主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final long id) {
        return super.removeById(id);
    }

    /**
     * 根据主键批量删除系统用户。
     *
     * @param ids 系统用户主键集合。
     * @return 是否删除成功。
     */
    @Override
    public boolean deleteBatch(final List<Long> ids) {
        return super.removeByIds(ids);
    }

    /**
     * 根据主键停用系统用户。
     *
     * @param id 系统用户主键。
     * @return 是否停用成功。
     */
    @Override
    public boolean disable(final long id) {
        final SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setStatus(SysUserStatus.DISABLE);
        return super.updateById(sysUser);
    }

    /**
     * 根据主键启用系统用户。
     *
     * @param id 系统用户主键。
     * @return 是否启用成功。
     */
    @Override
    public boolean enable(final long id) {
        final SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setStatus(SysUserStatus.ENABLE);
        return super.updateById(sysUser);
    }

    /**
     * 根据主键重置系统用户的登录密码。
     *
     * @param id 系统用户主键。
     * @return 是否重置成功。
     */
    @Override
    public boolean resetPassword(final long id) {
        // 生成新的登录密码。
        final String password = getPasswordStrategy().generate();
        final SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setPassword(password);
        return super.updateById(sysUser);
    }

    /**
     * 验证密码是否正确。
     *
     * @param input    输入的密码。
     * @param password 数据库中的密码。
     * @return 密码是否正确。
     */
    @Override
    public boolean verifyPassword(final String input, final String password) {
        return getPasswordStrategy().verify(input, password);
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
     * 根据帐号查询系统用户。
     *
     * @param account 帐号。
     * @return 系统用户的数据传输对象。
     */
    @Override
    public SysUserDto findByAccount(final String account) {
        final SysUser sysUser = super.getOne(
                createQueryWrapper().lambda().eq(SysUser::getAccount, account),
                QueryConst.DO_NOT_THROW_EX
        );
        final SysUserDto result = sysUserMapper.entityToDto(sysUser);
        if (log.isDebugEnabled()) {
            log.debug("根据帐号：{}，查询用户：{}", account, result.toString());
        }
        return result;
    }

    /**
     * 根据条件分页查询系统用户。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return 系统用户的分页对象。
     */
    @Override
    public PageVo<SysUserDto> pageByCondition(final SysUserDto sysUserDto) {
        final QueryWrapper<SysUser> wrapper = createQueryWrapper(sysUserDto);
        final Page<SysUser> page = PageUtil.createPage(sysUserDto);
        final Page<SysUser> users = super.page(page, wrapper);
        return sysUserMapper.entityPageToDtoPage(users);
    }

    /**
     * @return 创建QueryWrapper。
     */
    private QueryWrapper<SysUser> createQueryWrapper() {
        return new QueryWrapper<>();
    }

    /**
     * 创建带条件的QueryWrapper。
     *
     * @param sysUserDto 系统用户数据传输对象。
     * @return 带条件的QueryWrapper。
     */
    private QueryWrapper<SysUser> createQueryWrapper(final SysUserDto sysUserDto) {
        final SysUser sysUser = sysUserMapper.dtoToEntity(sysUserDto);
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<SysUser> lambda = wrapper.lambda();
        if (StringUtils.isNotBlank(sysUser.getAccount())) {
            lambda.like(SysUser::getAccount, sysUser.getAccount());
        }
        if (StringUtils.isNotBlank(sysUser.getPhoneNumber())) {
            lambda.like(SysUser::getPhoneNumber, sysUser.getPhoneNumber());
        }
        if (StringUtils.isNotBlank(sysUser.getEmail())) {
            lambda.like(SysUser::getEmail, sysUser.getEmail());
        }
        if (StringUtils.isNotBlank(sysUser.getChineseName())) {
            lambda.like(SysUser::getChineseName, sysUser.getChineseName());
        }
        if (StringUtils.isNotBlank(sysUser.getEnglishName())) {
            lambda.like(SysUser::getEnglishName, sysUser.getEnglishName());
        }
        if (StringUtils.isNotBlank(sysUser.getNickName())) {
            lambda.like(SysUser::getNickName, sysUser.getNickName());
        }
        if (ObjectUtils.isNotEmpty(sysUser.getBirthday())) {
            lambda.eq(SysUser::getBirthday, sysUser.getBirthday());
        }
        if (ObjectUtils.isNotEmpty(sysUser.getGender())) {
            lambda.eq(SysUser::getGender, sysUser.getGender());
        }
        if (ObjectUtils.isNotEmpty(sysUser.getStatus())) {
            lambda.eq(SysUser::getStatus, sysUser.getStatus());
        }
        // 创建时间查询条件
        if (ObjectUtils.isNotEmpty(sysUserDto.getBeginCreateTime())
                && ObjectUtils.isNotEmpty(sysUserDto.getEndCreateTime())) {
            lambda.between(SysUser::getCreateTime, sysUserDto.getBeginCreateTime(), sysUserDto.getEndCreateTime());
        }
        if (ObjectUtils.isNotEmpty(sysUserDto.getBeginCreateTime())
                && ObjectUtils.isNotEmpty(sysUserDto.getEndCreateTime())) {
            lambda.between(SysUser::getCreateTime, sysUserDto.getBeginCreateTime(), LocalDateTime.now());
        }
        if (ObjectUtils.isEmpty(sysUserDto.getBeginCreateTime())
                && ObjectUtils.isNotEmpty(sysUserDto.getEndCreateTime())) {
            lambda.le(SysUser::getCreateTime, sysUserDto.getEndCreateTime());
        }
        // 修改时间查询条件
        if (ObjectUtils.isNotEmpty(sysUserDto.getBeginModifyTime())
                && ObjectUtils.isNotEmpty(sysUserDto.getEndModifyTime())) {
            lambda.between(SysUser::getModifyTime, sysUserDto.getBeginModifyTime(), sysUserDto.getEndModifyTime());
        }
        if (ObjectUtils.isNotEmpty(sysUserDto.getBeginModifyTime())
                && ObjectUtils.isNotEmpty(sysUserDto.getEndModifyTime())) {
            lambda.between(SysUser::getModifyTime, sysUserDto.getBeginModifyTime(), LocalDateTime.now());
        }
        if (ObjectUtils.isEmpty(sysUserDto.getBeginModifyTime())
                && ObjectUtils.isNotEmpty(sysUserDto.getEndModifyTime())) {
            lambda.le(SysUser::getModifyTime, sysUserDto.getEndModifyTime());
        }
        return wrapper;
    }

    /**
     * @return 获取登录密码策略的接口。
     */
    private PasswordStrategy getPasswordStrategy() {
        return passwordStrategyFactory.getInstance(systemProperty.getSysUserProperty().getPasswordStrategyType());
    }

    /**
     * @return 获取系统用户对象转换接口。
     */
    @Override
    public SysUserMapper getSysUserMapper() {
        return this.sysUserMapper;
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
     * 自动装配登录密码策略的工厂类
     *
     * @param passwordStrategyFactory 登录密码策略的工厂类
     */
    @Autowired
    public void setPasswordStrategyFactory(PasswordStrategyFactory passwordStrategyFactory) {
        this.passwordStrategyFactory = passwordStrategyFactory;
    }

    /**
     * 自动装配系统管理的自定义配置类。
     *
     * @param systemProperty 系统管理的自定义配置类。
     */
    @Autowired
    public void setSystemProperty(SystemProperty systemProperty) {
        this.systemProperty = systemProperty;
    }

    /**
     * 系统用户对象转换接口。
     */
    private SysUserMapper sysUserMapper;

    /**
     * 登录密码策略的工厂类。
     */
    private PasswordStrategyFactory passwordStrategyFactory;

    /**
     * 系统管理的自定义配置类。
     */
    private SystemProperty systemProperty;

}
