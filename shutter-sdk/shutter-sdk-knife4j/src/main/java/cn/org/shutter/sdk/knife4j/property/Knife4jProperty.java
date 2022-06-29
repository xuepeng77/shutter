package cn.org.shutter.sdk.knife4j.property;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

/**
 * Knife4j的自定义属性类。
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "shutter.knife4j")
public class Knife4jProperty {

    /**
     * 在以下环境下，会启动Knife4j。
     */
    private List<String> profiles = Arrays.asList("dev", "test");

    /**
     * 是否启用。
     */
    private Boolean enabled = Boolean.TRUE;

    /**
     * API文档描述。
     */
    private String description;

    /**
     * API文档版本。
     */
    private String version;

    /**
     * API文档标题。
     */
    private String title;

    /**
     * 作者。
     */
    private String author;

    /**
     * 主页。
     */
    private String website;

    /**
     * 邮箱地址。
     */
    private String email;

    /**
     * 识别该包名下的Knife4j API。
     */
    private String basePackage = "cn.org.shutter";

}
