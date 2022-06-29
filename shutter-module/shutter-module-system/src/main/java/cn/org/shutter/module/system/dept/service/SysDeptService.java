package cn.org.shutter.module.system.dept.service;

import cn.org.shutter.module.system.dept.dto.SysDeptDto;
import cn.org.shutter.module.system.dept.mapper.SysDeptMapper;

import java.util.List;

/**
 * 系统组织结构的业务处理接口。
 *
 * @author xuepeng
 */
public interface SysDeptService {

    /**
     * 创建系统组织机构。
     *
     * @param sysDeptDto 系统组织机构的的数据传输对象。
     * @return 是否创建成功。
     */
    boolean create(final SysDeptDto sysDeptDto);

    /**
     * 修改系统组织机构。
     *
     * @param sysDeptDto 系统组织机构的的数据传输对象。
     * @return 是否修改成功。
     */
    boolean update(final SysDeptDto sysDeptDto);

    /**
     * 根据主键删除系统组织机构。
     *
     * @param id 系统组织机构的主键。
     * @return 是否删除成功。
     */
    boolean delete(final long id);

    /**
     * 根据主键停用系统组织机构。
     *
     * @param id 系统组织机构的主键。
     * @return 是否停用成功。
     */
    boolean disable(final long id);

    /**
     * 根据主键启用系统组织机构。
     *
     * @param id 系统组织机构的主键。
     * @return 是否启用成功。
     */
    boolean enable(final long id);

    /**
     * 根据主键查询系统组织机构。
     * 当根据主键查询不到组织机构时，抛出SysDeptNotFoundException异常对象。
     *
     * @param id 系统组织机构的主键。
     * @return 系统组织机构的数据传输对象。
     */
    SysDeptDto findById(final long id);

    /**
     * 根据主键批量查询系统组织机构。
     *
     * @param ids 系统组织机构的主键集合。
     * @return 系统组织机构的数据传输对象集合。
     */
    List<SysDeptDto> findByIds(final List<Long> ids);

    /**
     * 查询全部系统组织机构并转换成树。
     *
     * @return 系统组织机构的数据传输对象树。
     */
    List<SysDeptDto> findAllToTree();

    /**
     * @return 获取系统组织机构对象转换接口。
     */
    SysDeptMapper getSysDeptMapper();

}
