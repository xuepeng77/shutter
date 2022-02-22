package cn.org.niubility.shutter.sdk.orm.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MybatisPlus配置类
 *
 * @author Chill
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "shutter.orm")
public class MybatisPlusProperties {

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
