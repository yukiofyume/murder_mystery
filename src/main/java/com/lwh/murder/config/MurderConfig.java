package com.lwh.murder.config;

//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwh
 * @date 2021/4/12 20:20
 */
@Configuration
@MapperScan("com.lwh.murder.mapper")
public class MurderConfig {

    /**
    * 分页插件
     * 这个插件在不同版本下有区别
    */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
