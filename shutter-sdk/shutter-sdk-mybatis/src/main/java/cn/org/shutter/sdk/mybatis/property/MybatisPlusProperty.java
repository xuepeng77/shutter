package cn.org.shutter.sdk.mybatis.property;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MybatisPlus的自定义属性类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "shutter.mybatis")
public class MybatisPlusProperty {

    /**
     * 分页最大数
     */
    private Long pageLimit = 100L;

    /**
     * 溢出总页数后是否进行处理
     */
    protected Boolean overflow = false;

    /**
     * join优化
     */
    private Boolean optimizeJoin = false;

}
