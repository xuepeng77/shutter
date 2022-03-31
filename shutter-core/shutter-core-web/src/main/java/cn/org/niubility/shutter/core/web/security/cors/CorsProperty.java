package cn.org.niubility.shutter.core.web.security.cors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Duration;

/**
 * 跨域配置信息。
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CorsProperty {

    /**
     * 配置允许跨域的路由。
     */
    private String mapping = "/**";
    /**
     * 配置允许跨域的Header。
     */
    private String headers = "*";
    /**
     * 配置允许跨域的请求源。
     */
    private String origins = "*";
    /**
     * 配置允许跨域的Method。
     */
    private String methods = "*";
    /**
     * 配置通过后无需在验证的时间。
     */
    private Duration age = Duration.ofHours(1);
    /**
     * 配置是否允许传递Cookie。
     */
    private boolean credentials = true;

}
