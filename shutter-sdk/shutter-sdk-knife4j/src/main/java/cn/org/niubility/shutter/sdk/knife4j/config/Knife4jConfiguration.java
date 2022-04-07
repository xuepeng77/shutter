package cn.org.niubility.shutter.sdk.knife4j.config;

import cn.org.niubility.shutter.sdk.knife4j.property.Knife4jProperty;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Knife4j的配置类。
 * 配置Knife4j的文档信息，关闭Prod环境的文档访问。
 *
 * @author xuepeng
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
@EnableConfigurationProperties(Knife4jProperty.class)
public class Knife4jConfiguration {

    /**
     * @return 创建API文档。
     */
    @Bean
    public Docket createRestApi(final Knife4jProperty knife4jProperties) {
        // 设置显示的swagger环境信息
        Profiles profiles = Profiles.of(knife4jProperties.getProfiles().toArray(new String[0]));
        // 判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo(knife4jProperties))
                .enable(knife4jProperties.getEnabled())
                .select()
                .apis(RequestHandlerSelectors.basePackage(knife4jProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @return 创建API信息。
     */
    private ApiInfo apiInfo(final Knife4jProperty knife4jProperties) {
        return new ApiInfoBuilder()
                .description(knife4jProperties.getDescription())
                .contact(new Contact(
                        knife4jProperties.getAuthor(),
                        knife4jProperties.getWebsite(),
                        knife4jProperties.getEmail()))
                .version(knife4jProperties.getVersion())
                .title(knife4jProperties.getTitle())
                .build();
    }

    /**
     * 自动装配环境对象。
     *
     * @param environment 环境对象。
     */
    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * 环境对象。
     */
    private Environment environment;

}
