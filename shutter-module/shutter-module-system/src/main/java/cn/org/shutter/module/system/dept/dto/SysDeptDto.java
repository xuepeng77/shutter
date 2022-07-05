package cn.org.shutter.module.system.dept.dto;

import cn.org.shutter.core.common.bean.dto.BaseDto;
import cn.org.shutter.core.common.util.TreeStruct;
import cn.org.shutter.module.system.dept.enums.SysDeptStatus;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统组织机构的数据传输类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysDeptDto extends BaseDto implements TreeStruct {

    /**
     * @return 获取树节点的Id。
     */
    @Override
    public String getNodeId() {
        return String.valueOf(super.getId());
    }

    /**
     * @return 获取树节点的Pid。
     */
    @Override
    public String getNodePid() {
        return String.valueOf(this.getParentId());
    }

    /**
     * 添加树的子节点。
     *
     * @param node 子节点。
     */
    @Override
    public void addChild(TreeStruct node) {
        this.getChildren().add((SysDeptDto) node);
    }

    /**
     * 父级主键。
     */
    private Long parentId;

    /**
     * 名称。
     */
    private String name;

    /**
     * 编号。
     */
    private String code;

    /**
     * 状态：0=禁用；1=启用。
     */
    private SysDeptStatus status;

    /**
     * 排序。
     */
    private Integer orderId;

    /**
     * 备注。
     */
    private String remark;

    /**
     * 子机构。
     */
    private List<SysDeptDto> children = new ArrayList<>();

}
