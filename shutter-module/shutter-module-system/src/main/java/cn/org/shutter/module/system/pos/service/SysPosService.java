package cn.org.shutter.module.system.pos.service;

import cn.org.shutter.core.common.bean.vo.PageVo;
import cn.org.shutter.module.system.pos.dto.SysPosDto;
import cn.org.shutter.module.system.pos.mapper.SysPosMapper;

import java.util.List;

/**
 * 系统岗位的业务处理接口。
 *
 * @author xuepeng
 */
public interface SysPosService {

    /**
     * 创建系统岗位。
     *
     * @param sysPosDto 系统岗位的的数据传输对象。
     * @return 是否创建成功。
     */
    boolean create(final SysPosDto sysPosDto);

    /**
     * 修改系统岗位。
     *
     * @param sysPosDto 系统岗位的的数据传输对象。
     * @return 是否修改成功。
     */
    boolean update(final SysPosDto sysPosDto);

    /**
     * 根据主键删除系统岗位。
     *
     * @param id 系统岗位的主键。
     * @return 是否删除成功。
     */
    boolean delete(final long id);

    /**
     * 根据主键停用系统岗位。
     *
     * @param id 系统岗位的主键。
     * @return 是否停用成功。
     */
    boolean disable(final long id);

    /**
     * 根据主键启用系统岗位。
     *
     * @param id 系统岗位的主键。
     * @return 是否启用成功。
     */
    boolean enable(final long id);

    /**
     * 根据主键查询系统岗位。
     * 当根据主键查询不到岗位时，抛出SysPosNotFoundException异常对象。
     *
     * @param id 系统岗位的主键。
     * @return 系统岗位的数据传输对象。
     */
    SysPosDto findById(final long id);

    /**
     * 根据主键批量查询系统岗位。
     *
     * @param ids 系统岗位的主键集合。
     * @return 系统岗位的数据传输对象集合。
     */
    List<SysPosDto> findByIds(final List<Long> ids);

    /**
     * 根据条件分页查询系统岗位。
     *
     * @param sysPosDto 系统岗位的数据传输对象。
     * @return 系统岗位的分页对象。
     */
    PageVo<SysPosDto> pageByCondition(final SysPosDto sysPosDto);

    /**
     * @return 获取系统岗位对象转换接口。
     */
    SysPosMapper getSysPosMapper();

}
