package cn.org.shutter.sdk.satoken.property;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * SaToken的自定义属性类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("shutter.auth")
public class SaTokenProperty {

    /**
     * 拦截路径。
     */
    private String includePath;

    /**
     * 放行路径。
     */
    private List<String> excludePaths = new ArrayList<>();

}
