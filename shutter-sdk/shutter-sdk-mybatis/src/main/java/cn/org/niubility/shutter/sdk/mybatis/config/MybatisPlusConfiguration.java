package cn.org.niubility.shutter.sdk.mybatis.config;

import cn.org.niubility.shutter.sdk.mybatis.property.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MybatisEnumTypeHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBaits Plus的配置类。
 * 自动扫描cn.org.niubility.shutter.**.dao.**下的Dao类。
 * 配置枚举处理。
 * 配置分页拦截器。
 *
 * @author xuepeng
 */
@Configuration
@MapperScan("cn.org.niubility.shutter.**.dao.**")
@EnableConfigurationProperties(MybatisPlusProperties.class)
public class MybatisPlusConfiguration {

    // TODO 加入租户、逻辑删除、数据权限功能

    /**
     * @return 配置MybaitsPlus属性。
     */
    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer() {
        return properties -> {
            GlobalConfig globalConfig = properties.getGlobalConfig();
            globalConfig.setBanner(false);
            MybatisConfiguration configuration = new MybatisConfiguration();
            // 配置枚举处理
            configuration.setDefaultEnumTypeHandler(MybatisEnumTypeHandler.class);
            properties.setConfiguration(configuration);
        };
    }

    /**
     * @return 添加插件。
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(final MybatisPlusProperties mybatisPlusProperties) {
        final MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页插件
        interceptor.addInnerInterceptor(paginationInnerInterceptor(mybatisPlusProperties));
        // 添加乐观所插件
        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor());
        return interceptor;
    }

    /**
     * @return 配置分页插件。
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(MybatisPlusProperties mybatisPlusProperties) {
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        paginationInterceptor.setMaxLimit(mybatisPlusProperties.getPageLimit());
        paginationInterceptor.setOverflow(mybatisPlusProperties.getOverflow());
        paginationInterceptor.setOptimizeJoin(mybatisPlusProperties.getOptimizeJoin());
        return paginationInterceptor;
    }

    /**
     * @return 配置乐观锁插件。
     */
    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }

}
