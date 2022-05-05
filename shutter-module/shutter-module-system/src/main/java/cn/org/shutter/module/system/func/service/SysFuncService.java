package cn.org.shutter.module.system.func.service;

import cn.org.shutter.module.system.func.dto.SysFuncDto;
import cn.org.shutter.module.system.func.mapper.SysFuncMapper;

import java.util.List;

/**
 * 系统功能的业务处理接口。
 *
 * @author xuepeng
 */
public interface SysFuncService {

    /**
     * 创建系统功能。
     *
     * @param sysFuncDto 系统功能的的数据传输对象。
     * @return 是否创建成功。
     */
    boolean create(final SysFuncDto sysFuncDto);

    /**
     * 修改系统功能。
     *
     * @param sysFuncDto 系统功能的的数据传输对象。
     * @return 是否修改成功。
     */
    boolean update(final SysFuncDto sysFuncDto);

    /**
     * 根据主键删除系统功能。
     *
     * @param id 系统功能的主键。
     * @return 是否删除成功。
     */
    boolean delete(final long id);

    /**
     * 根据主键停用系统功能。
     *
     * @param id 系统功能的主键。
     * @return 是否停用成功。
     */
    boolean disable(final long id);

    /**
     * 根据主键启用系统功能。
     *
     * @param id 系统功能的主键。
     * @return 是否启用成功。
     */
    boolean enable(final long id);

    /**
     * 根据主键查询系统功能。
     * 当根据主键查询不到功能时，抛出SysFuncNotFoundException异常对象。
     *
     * @param id 系统功能的主键。
     * @return 系统功能的数据传输对象。
     */
    SysFuncDto findById(final long id);

    /**
     * 根据主键批量查询系统功能。
     *
     * @param ids 系统功能的主键集合。
     * @return 系统功能的数据传输对象集合。
     */
    List<SysFuncDto> findByIds(final List<Long> ids);

    /**
     * 查询全部系统功能并转换成树。
     *
     * @return 系统功能的数据传输对象树。
     */
    List<SysFuncDto> findAllToTree();

    /**
     * @return 获取系统功能对象转换接口。
     */
    SysFuncMapper getSysFuncMapper();

}
