package cn.org.shutter.module.system.user.service;

import cn.org.shutter.module.property.SystemProperty;
import cn.org.shutter.module.system.role.service.SysRoleUserService;
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
import cn.org.shutter.sdk.mybatis.util.QueryWrapperUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param id 系统用户的主键。
     * @return 是否删除成功。
     */
    @Override
    public boolean delete(final long id) {
        return super.removeById(id);
    }

    /**
     * 根据主键批量删除系统用户。
     *
     * @param ids 系统用户的主键集合。
     * @return 是否删除成功。
     */
    @Override
    public boolean deleteBatch(final List<Long> ids) {
        return super.removeByIds(ids);
    }

    /**
     * 根据主键停用系统用户。
     *
     * @param id 系统用户的主键。
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
     * @param id 系统用户的主键。
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
     * @param id 系统用户的主键。
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
     * @param id 系统用户的主键。
     * @return 系统用户的的数据传输对象。
     */
    @Override
    public SysUserDto findById(final long id) {
        final SysUser sysUser = super.getById(id);
        // 当根据主键查询不到用户时，抛出SysUserNotFoundException异常对象。
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new SysUserNotFoundException("根据主键[" + id + "]未能查询到系统用户。");
        }
        return sysUserMapper.entityToDto(sysUser);
    }

    /**
     * 根据帐号查询系统用户。
     *
     * @param account 帐号。
     * @return 系统用户的数据传输对象。
     */
    @Override
    public SysUserDto findByAccount(final String account) {
        final QueryWrapper<SysUser> wrapper = QueryWrapperUtil.createQueryWrapper();
        final LambdaQueryWrapper<SysUser> lambda = wrapper.lambda();
        final SysUser sysUser = super.getOne(
                lambda.eq(SysUser::getAccount, account),
                QueryConst.DO_NOT_THROW_EX
        );
        return sysUserMapper.entityToDto(sysUser);
    }

    /**
     * 根据条件分页查询系统用户。
     *
     * @param sysUserDto 系统用户的数据传输对象。
     * @return 系统用户的分页对象。
     */
    @Override
    public Page<SysUserDto> pageByCondition(final SysUserDto sysUserDto) {
        final QueryWrapper<SysUser> wrapper = createQueryWrapper(sysUserDto);
        final Page<SysUser> page = PageUtil.createPage(sysUserDto);
        final Page<SysUser> users = super.page(page, wrapper);
        return sysUserMapper.entityPageToDtoPage(users);
    }

    /**
     * 给一个系统用户授权多个系统角色。
     *
     * @param id      系统用户的主键。
     * @param roleIds 系统角色主键集合。
     */
    @Override
    public void saveRoles(final long id, final List<Long> roleIds) {
        sysRoleUserService.saveRolesToUser(id, roleIds);
    }

    /**
     * 查询系统用户下已授权的系统角色。
     *
     * @param id 系统用户的主键。
     * @return 系统角色主键集合。
     */
    @Override
    public List<Long> findRoles(final long id) {
        return sysRoleUserService.findRolesByUserId(id);
    }

    /**
     * 创建带条件的QueryWrapper。
     *
     * @param sysUserDto 系统用户数据传输对象。
     * @return 带条件的QueryWrapper。
     */
    private QueryWrapper<SysUser> createQueryWrapper(final SysUserDto sysUserDto) {
        final SysUser sysUser = sysUserMapper.dtoToEntity(sysUserDto);
        final QueryWrapper<SysUser> wrapper = QueryWrapperUtil.createQueryWrapper(sysUserDto);
        final LambdaQueryWrapper<SysUser> lambda = wrapper.lambda();
        lambda.like(StringUtils.isNotBlank(sysUser.getAccount()), SysUser::getAccount, sysUser.getAccount());
        lambda.like(StringUtils.isNotBlank(sysUser.getPhoneNumber()), SysUser::getPhoneNumber, sysUser.getPhoneNumber());
        lambda.like(StringUtils.isNotBlank(sysUser.getEmail()), SysUser::getEmail, sysUser.getEmail());
        lambda.like(StringUtils.isNotBlank(sysUser.getChineseName()), SysUser::getChineseName, sysUser.getChineseName());
        lambda.like(StringUtils.isNotBlank(sysUser.getEnglishName()), SysUser::getEnglishName, sysUser.getEnglishName());
        lambda.like(StringUtils.isNotBlank(sysUser.getNickName()), SysUser::getNickName, sysUser.getNickName());
        lambda.eq(ObjectUtils.isNotEmpty(sysUser.getBirthday()), SysUser::getBirthday, sysUser.getBirthday());
        lambda.eq(ObjectUtils.isNotEmpty(sysUser.getGender()), SysUser::getGender, sysUser.getGender());
        lambda.eq(ObjectUtils.isNotEmpty(sysUser.getStatus()), SysUser::getStatus, sysUser.getStatus());
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
     * 自动装配系统角色与系统用户关系的业务处理接口。
     *
     * @param sysRoleUserService 系统角色与系统用户关系的业务处理接口。
     */
    @Autowired
    public void setSysRoleUserService(SysRoleUserService sysRoleUserService) {
        this.sysRoleUserService = sysRoleUserService;
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

    /**
     * 系统角色与系统用户关系的业务处理接口。
     */
    private SysRoleUserService sysRoleUserService;


}
