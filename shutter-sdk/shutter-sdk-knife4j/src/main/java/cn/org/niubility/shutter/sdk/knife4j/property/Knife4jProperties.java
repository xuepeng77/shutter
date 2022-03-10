package cn.org.niubility.shutter.sdk.knife4j.property;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

/**
 * Knife4j自定义属性类。
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "shutter.knife4j")
public class Knife4jProperties {

    /**
     * 在以下环境下，会启动Knife4j。
     */
    private List<String> profiles = Arrays.asList("dev", "test");

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
    private String basePackage = "cn.org.niubility.shutter";

}
