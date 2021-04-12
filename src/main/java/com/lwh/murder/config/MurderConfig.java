package com.lwh.murder.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lwh
 * @date 2021/4/12 20:20
 */
@Configuration
@MapperScan("com.lwh.murder.mapper")
public class MurderConfig {
}
