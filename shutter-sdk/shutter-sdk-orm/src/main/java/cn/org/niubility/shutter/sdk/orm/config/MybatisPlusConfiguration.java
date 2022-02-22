package cn.org.niubility.shutter.sdk.orm.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.org.niubility.shutter.**.mapper.**")
@EnableConfigurationProperties(MybatisPlusProperties.class)
public class MybatisPlusConfiguration {

    /**
     * @return 配置MyBatis拦截器。
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(MybatisPlusProperties mybatisPlusProperties) {
        final MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页插件
        interceptor.addInnerInterceptor(paginationInnerInterceptor(mybatisPlusProperties));
        return interceptor;
    }

    /**
     * @return 配置分页拦截器。
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(MybatisPlusProperties mybatisPlusProperties) {
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        paginationInterceptor.setMaxLimit(mybatisPlusProperties.getPageLimit());
        paginationInterceptor.setOverflow(mybatisPlusProperties.getOverflow());
        paginationInterceptor.setOptimizeJoin(mybatisPlusProperties.getOptimizeJoin());
        return paginationInterceptor;
    }

}
