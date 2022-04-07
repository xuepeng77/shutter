package cn.org.shutter.sdk.satoken.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.org.shutter.sdk.satoken.property.SaTokenProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SaToken的配置类。
 *
 * @author xuepeng
 */
@Configuration
@EnableConfigurationProperties(SaTokenProperty.class)
public class SaTokenConfiguration implements WebMvcConfigurer {

    /**
     * 注册SaToken的注解拦截器。
     *
     * @param registry 拦截器注册器。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor())
                .addPathPatterns(saTokenProperty.getIncludePath())
                .excludePathPatterns(saTokenProperty.getExcludePaths());
    }

    /**
     * SaToken的自定义属性对象。
     *
     * @param saTokenProperty SaToken的自定义属性类。
     */
    @Autowired
    public void setSaTokenProperty(SaTokenProperty saTokenProperty) {
        this.saTokenProperty = saTokenProperty;
    }

    /**
     * SaToken的自定义属性对象。
     */
    private SaTokenProperty saTokenProperty;

}
