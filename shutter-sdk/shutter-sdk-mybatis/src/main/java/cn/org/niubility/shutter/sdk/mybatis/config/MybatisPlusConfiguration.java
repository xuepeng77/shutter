package cn.org.niubility.shutter.sdk.mybatis.config;

import cn.org.niubility.shutter.sdk.mybatis.property.MybatisPlusProperty;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MybatisEnumTypeHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBaits Plus的配置类。
 * 自动扫描cn.org.niubility.shutter.**.dao.**下的Dao类。
 * 配置MyBatis Plus和MyBatis。
 * 配置枚举处理。
 * 配置分页插件。
 * 配置乐观锁插件。
 *
 * @author xuepeng
 */
@Configuration
@MapperScan(basePackages = {"cn.org.niubility.shutter.**.dao.**"})
@EnableConfigurationProperties(MybatisPlusProperty.class)
public class MybatisPlusConfiguration {

    // TODO 加入租户、数据权限功能

    /**
     * @return 配置MybaitsPlus属性。
     */
    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer() {
        return properties -> {
            // MyBatis Plus的配置
            properties.setMapperLocations(new String[]{"classpath*:mapper/*.xml"});

            // 设置逻辑删除
            final GlobalConfig globalConfig = properties.getGlobalConfig();
            globalConfig.setBanner(false);
            globalConfig.getDbConfig().setLogicDeleteField("deleted");
            globalConfig.getDbConfig().setLogicDeleteValue("1");
            globalConfig.getDbConfig().setLogicNotDeleteValue("0");

            // MyBatis的配置
            MybatisConfiguration configuration = new MybatisConfiguration();
            configuration.setDefaultEnumTypeHandler(MybatisEnumTypeHandler.class);
            configuration.setLogImpl(StdOutImpl.class);
            properties.setConfiguration(configuration);
        };
    }

    /**
     * @return 添加插件。
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(final MybatisPlusProperty mybatisPlusProperties) {
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
    public PaginationInnerInterceptor paginationInnerInterceptor(MybatisPlusProperty mybatisPlusProperties) {
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
